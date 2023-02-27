package com.rafaur.gateway.gateway.mapp;

import org.mapstruct.ReportingPolicy;

@org.mapstruct.MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperConfig {
}