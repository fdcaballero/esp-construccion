package com.esp.infraestructura.s3;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.PresignedPutObjectRequest;

import java.io.IOException;
import java.time.Duration;

@Service
public class S3Service {
    private final S3Presigner presigner;
    private final S3Client s3Client;

    public S3Service(S3Client s3Client, S3Presigner presigner) {
        this.s3Client = s3Client;
        this.presigner = presigner;
    }

    public void listarBuckets() {
        ListBucketsResponse listBucketsResponse = s3Client.listBuckets();
        listBucketsResponse.buckets().forEach(bucket -> System.out.println(bucket.name()));
    }

    public void load(String bucket, String key, MultipartFile file) throws IOException {
        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(key)
                .build();
        s3Client.putObject(putObjectRequest,
                RequestBody
                        .fromInputStream(file.getInputStream(),
                                file.getSize()));
    }

    public ResponseInputStream<GetObjectResponse> getObject(String bucket, String key) {
        GetObjectRequest request = GetObjectRequest
                .builder()
                .bucket(bucket)
                .key(key).build();

        return s3Client.getObject(request);
    }

    public String generatePreSignedUrl(String bucket, String objectKey) {


        PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                .bucket(bucket)
                .key(objectKey)
                .build();

        PresignedPutObjectRequest presignedRequest = presigner.presignPutObject(builder -> builder
                .putObjectRequest(putObjectRequest)
                .signatureDuration(Duration.ofMinutes(10))
        );

        return presignedRequest.url().toString();
    }
}
