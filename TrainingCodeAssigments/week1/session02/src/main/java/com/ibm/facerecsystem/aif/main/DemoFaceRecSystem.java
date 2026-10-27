package com.ibm.facerecsystem.aif.main;

import com.ibm.facerecsystem.aif.db.*;

//raj
public class DemoFaceRecSystem {
    public static void main(String[] args) {
        //DB face class: 9 out of 10
        Face face = new Face();
        face.saveFacePixel();

        //if two classes with the smaem name used in one class
        //then once should be fully qualified
        com.ibm.facerecsystem.aif.ui.Face face1 =
                new com.ibm.facerecsystem.aif.ui.Face();
        face1.displayFace();
    }
}
