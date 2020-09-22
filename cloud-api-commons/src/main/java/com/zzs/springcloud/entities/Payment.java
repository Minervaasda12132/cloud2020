package com.zzs.springcloud.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
    private static final long serialVersionUID = 1L;
    public static final String COL_ID = "id";
    public static final String COL_SERIAL = "serial";
}