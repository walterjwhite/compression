package com.walterjwhite.modules.compression.xz.guice;

import com.google.inject.AbstractModule;
import com.walterjwhite.compression.modules.XZCompressionService;
import com.walterjwhite.encryption.api.service.CompressionService;

public class XZCompressionModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(CompressionService.class).to(XZCompressionService.class);
  }
}
