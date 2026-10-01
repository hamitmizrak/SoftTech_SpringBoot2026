package com.hamitmizrak.services.interfaces;

import com.hamitmizrak.services.*;

// D: Dto
// E: Entity
public interface IBlogCategoryServices<D,E> extends
        IModelMapperService<D,E>,
        ISpeedAndDeleteService<D,E>,
        ICrudService<D,E>
        {
}
