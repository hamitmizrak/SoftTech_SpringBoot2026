package com.hamitmizrak.controller.api;

import com.hamitmizrak.error.ApiResult;
import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
// E: Entity
public interface ICrudApi<D,E>{

    // CRUD
    // CREATE
    public ResponseEntity<ApiResult<D>>  objectApiCreate(D d);

    // LIST
    public ResponseEntity<ApiResult<List<D>>>   objectApiList();

    // FIND BY ID
    public ResponseEntity<ApiResult<D>>    objectApiFindById(Long id);

    // UPDATE
    public ResponseEntity<ApiResult<D>>   objectApiUpdate(Long id, D d);

    // DELETE
    public ResponseEntity<ApiResult<D>>   objectApiDelete(Long id);

}
