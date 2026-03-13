package com.nexus.nexus_list.config.jwt.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PresignedUrlResponse {
    private String url;  // URL temporária para o front fazer o PUT direto no S3
    private String key;  // Key para salvar no banco: "profiles/uuid.jpg"
}