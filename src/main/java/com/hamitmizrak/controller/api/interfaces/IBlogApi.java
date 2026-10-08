package com.hamitmizrak.controller.api.interfaces;

import com.hamitmizrak.controller.api.ICrudApi;
import com.hamitmizrak.controller.api.IImageApi;
import com.hamitmizrak.controller.api.ISortingPagingApi;
import com.hamitmizrak.controller.api.ISpeedAndDeleteApi;

// D: Dto
public interface IBlogApi<D> extends
        ISpeedAndDeleteApi<D>,
        ICrudApi<D>,
        IImageApi<D>,
        ISortingPagingApi<D>
{
}
