package com.baizhi.controller;

import com.baizhi.common.FileVo;
import com.baizhi.common.ResultVo;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author dongHua
 * @create 2022/12/29 11:20
 * FileName: FileController
 */
@RestController
@CrossOrigin
public class FileController {
  /*  @Autowired
    private MinioClient minioClient;
    @Value("${minio.bucketName}")
    private String bucketName;
    @Value("${minio.endpoint}")
    private String endpoint;
    @PostMapping("/minio/upload")
    public ResultVo uploadPic(MultipartFile file) throws IOException, ServerException, InsufficientDataException, ErrorResponseException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        String originalFilename = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString()+ originalFilename;
            InputStream in = file.getInputStream();
            minioClient.putObject(PutObjectArgs.builder()
                    .bucket(bucketName)
                    .object("20221229/"+newName)
                    .stream(in, file.getSize(), -1)
                    .contentType(file.getContentType())
                    .build());
          in.close();
        FileVo fileVo = new FileVo().setUrl(endpoint + "/" + bucketName + "/20221229/" + newName).setName(newName);
        return new ResultVo().setCode(200).setMessage("成功").setData(fileVo);
    }
    @PostMapping("/minio/delete")
    public ResultVo deletePic(String objectName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        System.out.println(objectName);
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
        return new ResultVo().setCode(200).setMessage("成功").setData(null);
    }*/
}
