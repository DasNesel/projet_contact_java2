package Controler;

import bdd.Entities.Contact;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class vcard {

    private Contact contact;

    public vcard(Contact contact) {
        this.contact = contact;
    }

    public void generate(){
        String path = "vcard/" + contact.getFirstname() + "_" + contact.getLastname() + ".vcf";
        //String path = "vcard/test.vcf";
        Path pathFile = Paths.get(path);
        try {
            List<String> lignes= new ArrayList<String>();
            lignes.add("BEGIN:VCARD");
            lignes.add("VERSION:3.0");
            lignes.add("N:"+contact.getLastname()+";"+contact.getFirstname()+";;;");
            lignes.add("FN:"+contact.getLastname()+" "+contact.getFirstname());
            lignes.add("NICKNAME:"+contact.getNickname());
            if (contact.getPhoneMobil()!=null){
                lignes.add("TEL;TYPE=cell:"+contact.getPhoneMobil());
            }
            if (contact.getPhoneFix() != null){
                lignes.add("TEL;TYPE=home:"+contact.getPhoneFix());
            }
            if (contact.getAdress() != null){
                lignes.add("ADR;TYPE=WORK:;;"+contact.getAdress()+";;;;");
            }
            if (contact.getMail() != null){
                lignes.add("EMAIL;TYPE=internet,pref:"+contact.getMail());
            }
            if(contact.getWebsite() != null){
                lignes.add("URL:"+contact.getWebsite());
            }
            lignes.add("END:VCARD");

            Files.write(pathFile,lignes, StandardCharsets.UTF_8);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void importation(String path){
    }

}
