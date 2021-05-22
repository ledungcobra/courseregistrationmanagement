package com.ledungcobra.model;

import com.ledungcobra.entites.BaseEntity;
import lombok.SneakyThrows;
import lombok.val;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.List;

public class AbsComboModel<T extends BaseEntity> extends DefaultComboBoxModel<T> {

    @SneakyThrows
    public AbsComboModel(List<T> items, T... t) {
        super(items.toArray(t));
    }


}
