package com.walterjwhite.encryption.api.service;

import java.io.IOException;

public interface CompressionService {
  byte[] compress(byte[] uncompressedData) throws IOException;

  byte[] decompress(byte[] compressedMessage) throws IOException;
}
