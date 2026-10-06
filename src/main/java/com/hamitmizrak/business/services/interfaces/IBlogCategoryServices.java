package com.hamitmizrak.business.services.interfaces;

import com.hamitmizrak.business.services.ICrudService;
import com.hamitmizrak.business.services.IModelMapperService;
import com.hamitmizrak.business.services.ISpeedAndDeleteService;
import com.hamitmizrak.services.*;

// D: Dto
// E: Entity
public interface IBlogCategoryServices<D,E> extends
        IModelMapperService<D,E>,
        ISpeedAndDeleteService<D,E>,
        ICrudService<D,E>
        {
}
