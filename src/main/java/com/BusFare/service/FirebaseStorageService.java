package com.BusFare.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    final String BucketName = "busfare-e60fc.appspot.com";

    final String rutaSuperiorStorage = "BusFare";

    final String rutaJsonFile = "firebase";

    final String archivoJsonFile = "busfare-e60fc-firebase-adminsdk-gfynv-514a43200b.json";
}
