package com.rafaur.gateway.gateway.mapp;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

//@Mapper
public interface IMaper <I, O> {
//    @Mapping(target="employeeId", source="entity.id")
//    @Mapping(target="employeeName", source="entity.name")
    public O mapItoO(I in);
//    @Mapping(target="employeeId", source="entity.id")
//    @Mapping(target="employeeName", source="entity.name")
    public I mapOtoI(O in);
}

