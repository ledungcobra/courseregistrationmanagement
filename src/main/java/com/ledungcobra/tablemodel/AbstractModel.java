package com.ledungcobra.tablemodel;

import com.ledungcobra.entites.BaseEntity;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public abstract class AbstractModel<T extends BaseEntity> extends DefaultTableModel {
    public AbstractModel(List<T> t) {
        super();
        this.setDataVector(getRecords(t), getColumns());
    }

    public abstract Object[][] getRecords(List<T> l);

    public abstract String[] getColumns();

}
