package com.hamitmizrak.services.interfaces;

import com.hamitmizrak.services.*;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

// D: Dto
// E: Entity
public interface IBlogServices<D,E> extends
        IModelMapperService<D,E>,
        ISpeedAndDeleteService<D,E>,
        ICrudService<D,E>,
        IImageService<D,E>,
        ISortingPagingService<D,E> {

}
