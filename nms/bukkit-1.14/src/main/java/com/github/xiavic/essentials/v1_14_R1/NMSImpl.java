package com.github.xiavic.essentials.v1_14_R1;


import com.github.xiavic.lib.NMSHandler.NMS;
import com.github.xiavic.lib.inventory.InventorySerializer;
import com.github.xiavic.lib.signedit.ISignEditor;

public class NMSImpl implements NMS {

    public NMSImpl() {
    }

    private final ISignEditor signEditor = new SimpleSignEditor();

    @Override public ISignEditor getSignEditor() {
        return signEditor;
    }

    @Override public InventorySerializer getInventorySerializer() {
        return NBTInventorySerializer.INSTANCE;
    }
}
