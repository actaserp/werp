package com.actas.ems.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "SY_FILE_M")
@Entity
@NoArgsConstructor
@Getter
public class SyFileM {

    @Id
    @Column(name = "FILE_ID")
    private String fileId;

    @Column(name = "ORGN_FILE_NAME")
    private String orgnFileName;

    @Column(name = "PYSC_FILE_NAME")
    private String pyscFileName;

    @Column(name = "FILE_SIZE")
    private Long fileSize;


    /**
     * @param fileId
     * @param orgnFileName
     * @param pyscFileName
     * @param fileSize
     */
    public SyFileM(String fileId, String orgnFileName, String pyscFileName, long size) {
        this.fileId       = fileId;
        this.orgnFileName = orgnFileName;
        this.pyscFileName = pyscFileName;
        this.fileSize     = fileSize;
    }
//    public void SyFileM(String fileId, String orgnFileName, String pyscFileName, long fileSize) {
//        this.fileId       = fileId;
//        this.orgnFileName = orgnFileName;
//        this.pyscFileName = pyscFileName;
//        this.fileSize     = fileSize;
//    }
}
