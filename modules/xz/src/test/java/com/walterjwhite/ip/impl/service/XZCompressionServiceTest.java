package com.walterjwhite.ip.impl.service;

import com.google.inject.Injector;
import com.walterjwhite.compression.modules.CompressionModule;
import com.walterjwhite.encryption.api.service.CompressionService;
import com.walterjwhite.google.guice.GuiceHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XZCompressionServiceTest {
  private static final Logger LOGGER = LoggerFactory.getLogger(XZCompressionServiceTest.class);

  private static Injector GUICE_INJECTOR;

  @Before
  public void before() throws Exception {
    GuiceHelper.addModules(new CompressionModule());
    GuiceHelper.setup();
    GUICE_INJECTOR = GuiceHelper.getGuiceInjector();
  }

  @Test
  public void testCompressingData() throws IOException {
    final byte[] rawData = new byte[1024];
    for (int i = 0; i < rawData.length; i++) {
      rawData[i] = 0;
    }

    final File sourceFile = new File("/tmp/raw-test");
    IOUtils.write(rawData, new FileOutputStream(sourceFile));
    // FileUtils.write(new File("/tmp/raw-test"), rawData, false);

    CompressionService compressionService = GUICE_INJECTOR.getInstance(CompressionService.class);

    final byte[] compressed = compressionService.compress(rawData);
    final File outputFile = new File("/tmp/compressed-test");
    IOUtils.write(compressed, new FileOutputStream(outputFile));

    sourceFile.delete();
    outputFile.delete();
  }
}
