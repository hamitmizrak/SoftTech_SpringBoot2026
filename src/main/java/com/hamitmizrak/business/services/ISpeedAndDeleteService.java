package com.hamitmizrak.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface ISpeedAndDeleteService<D,E> {

    // SPEED CREATE & DELETE
    // SPEED DATA
    public List<D> speedData(Integer data);

    // DELETE ALL
    public List<D> deleteData();


}
