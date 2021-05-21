package com.ledungcobra.model;

import com.ledungcobra.entites.BaseEntity;
import com.ledungcobra.entites.Class;

import javax.swing.*;
import java.util.List;

public class AbsComboModel<T extends BaseEntity> extends DefaultComboBoxModel<T> {

    public AbsComboModel(List<T> items) {
        super((T[]) items.toArray(new Object[0]));
    }

}
