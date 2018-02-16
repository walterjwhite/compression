package com.walterjwhite.compression.modules;

import com.walterjwhite.encryption.api.service.CompressionService;
import java.io.*;
import org.apache.commons.compress.compressors.xz.XZCompressorInputStream;
import org.apache.commons.compress.compressors.xz.XZCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

public class XZCompressionService implements CompressionService {
  private static final int BUFFER_SIZE = 1024;

  @Override
  public byte[] compress(byte[] serializedMessage) throws IOException {
    try (final ByteArrayInputStream bais = new ByteArrayInputStream(serializedMessage)) {
      try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        try (final XZCompressorOutputStream outputStream = new XZCompressorOutputStream(baos)) {
          IOUtils.copy(bais, outputStream);
        }

        return (baos.toByteArray());
      }
    }
  }

  @Override
  public byte[] decompress(byte[] compressedMessage) throws IOException {

    try (final XZCompressorInputStream inputStream =
        new XZCompressorInputStream(new ByteArrayInputStream(compressedMessage))) {
      try (final ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        IOUtils.copy(inputStream, baos);
        return (baos.toByteArray());
      }
    }
  }
}
