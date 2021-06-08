package com.ledungcobra.model;

import com.ledungcobra.entites.BaseEntity;
import lombok.SneakyThrows;

import javax.swing.*;
import java.util.List;

public abstract class AbsComboModel<T extends BaseEntity> extends DefaultComboBoxModel<T>
{

    @SneakyThrows
    public AbsComboModel(List<T> items, T... t)
    {
        super(items.toArray(t));
    }

}
