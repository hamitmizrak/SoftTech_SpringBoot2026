package com.hamitmizrak.controller.api.interfaces;

import com.hamitmizrak.controller.api.ICrudApi;
import com.hamitmizrak.controller.api.ISpeedAndDeleteApi;

// D: Dto
public interface IBlogCategoryApi <D> extends
        ISpeedAndDeleteApi<D>,
        ICrudApi<D>
{
}
