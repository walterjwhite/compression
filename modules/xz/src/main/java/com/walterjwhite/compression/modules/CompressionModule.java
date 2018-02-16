package com.walterjwhite.compression.modules;

import com.google.inject.AbstractModule;
import com.walterjwhite.encryption.api.service.CompressionService;

public class CompressionModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(CompressionService.class).to(XZCompressionService.class);
  }
}
