package com.example.Messenger.Base.Model;

public enum Status {
    Active((short)1),
    InActive((short)-1);


   private short val;

   Status (short val){
     this.val=val;
   }

   public short getVal(){
       return val;
   }

   public static Status fromValue(short val) {
       for (Status status : values()) {
           if (status.val == val) {
               return status;
           }
       }
       throw new IllegalArgumentException("Unknown Status value: " + val);
   }

 

}
