package com.ruoyi.framework.config;

import com.ruoyi.common.config.MinioConfig;
import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Grand
 * @Description
 * @since 2024/6/5
 */
@Configuration
public class MinioComponent {

    private MinioConfig minioConfig;

    public MinioComponent(MinioConfig minioConfig) {
        this.minioConfig = minioConfig;
    }

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioConfig.getEndpoint())
                .credentials(minioConfig.getAccessKey(), minioConfig.getSecretKey())
                .build();
        return minioClient;
    }
}
