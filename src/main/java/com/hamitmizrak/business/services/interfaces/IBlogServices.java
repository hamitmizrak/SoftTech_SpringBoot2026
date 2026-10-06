package com.hamitmizrak.business.services.interfaces;

import com.hamitmizrak.business.services.*;

// D: Dto
// E: Entity
public interface IBlogServices<D,E> extends
        IModelMapperService<D,E>,
        ISpeedAndDeleteService<D,E>,
        ICrudService<D,E>,
        IImageService<D,E>,
        ISortingPagingService<D,E> {

}
