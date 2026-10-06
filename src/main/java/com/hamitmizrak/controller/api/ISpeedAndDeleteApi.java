package com.hamitmizrak.controller.api;

import com.hamitmizrak.error.ApiResult;
import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface ISpeedAndDeleteApi<D> {

    // SPEED CREATE & DELETE
    // SPEED DATA
    public ResponseEntity<ApiResult<List<D>>>  speedData(Integer data);

    // DELETE ALL
    public ResponseEntity<ApiResult<List<D>>> deleteData();


}
