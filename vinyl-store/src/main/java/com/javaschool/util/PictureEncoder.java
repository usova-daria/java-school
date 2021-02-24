package com.javaschool.util;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

public class PictureEncoder {

    private PictureEncoder() {}

    public static String toString(byte[] picture) {
        if (picture == null) return null;
        byte[] decodedPicture  = ImageCompress.decompressBytes(picture);
        return Base64.getEncoder().encodeToString(decodedPicture);
    }

    public static List<String> toStringList(List<byte[]> pictures) {
        return pictures.stream()
                .map(PictureEncoder::toString)
                .collect(Collectors.toList());
    }

}
