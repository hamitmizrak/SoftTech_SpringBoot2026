package com.hamitmizrak.controller.api;

import java.util.List;

// D: Dto
// E: Entity
public interface ISpeedAndDeleteApi<D,E> {

    // SPEED CREATE & DELETE
    // SPEED DATA
    public List<D> speedData(Integer data);

    // DELETE ALL
    public List<D> deleteData();


}
