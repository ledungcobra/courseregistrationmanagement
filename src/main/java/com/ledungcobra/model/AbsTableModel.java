package com.ledungcobra.model;

import com.ledungcobra.entites.BaseEntity;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public abstract class AbsTableModel<T extends BaseEntity> extends DefaultTableModel {
    protected Class[] types;
    boolean[] canEdit;

    public AbsTableModel(List<T> t) {
        super();
        this.setDataVector(getRecords(t), getColumns());
    }

    public abstract Object[][] getRecords(List<T> l);

    public abstract String[] getColumns();



    public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }

}
