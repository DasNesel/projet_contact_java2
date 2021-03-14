package Controler;

import bdd.Entities.Contact;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
            if (contact.getAdress() != null||contact.getCity() != null||contact.getCountry() != null){
                lignes.add("ADR;TYPE=WORK:;;"+contact.getAdress()+";"+contact.getCity()+";;;"+contact.getCountry());
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

    public void readVCF(String path){
        /*
        * Fonction permettant la lecture d'une VCard à partir d'un path données.
        *

        Path pathFile = Paths.get(path);
        try (Stream stream = Files.lines(pathFile, StandardCharsets.UTF_8)) {
            List<String> lignes= new ArrayList<String>();
            stream.forEach(lignes::add);

            if(lignes.get(0)=="BEGIN:VCARD"){
                for(int i=1;i<lignes.size();i++){
                    String ligne = lignes.get(i);
                    String[] parts = ligne.split(":");
                    if (parts[0]=="TEL"){
                        contact.setWebsite(parts[1]);
                    }
                }
            }

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
        }*/
    }

}
