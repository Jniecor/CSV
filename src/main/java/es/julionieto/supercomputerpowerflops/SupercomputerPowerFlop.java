package es.julionieto.supercomputerpowerflops;

public class SupercomputerPowerFlop {
    
    private String entity;
    private String code;
    private int year;
    private int floatingPointOperationsPerSecond;   
    
    public SupercomputerPowerFlop(){
    
    }
    
    public String getEntity(){
    
        return entity;
        
    }
    
    public void setEntity(String entity){
    
        this.entity = entity.toUpperCase();
    
    }
    
    public String getCode(){
    
        return code;
    
    }
    
    public void setCode(String code){
    
        this.code = code.toUpperCase();
    
    }
    
    public int getYear(){
    
        return year;
    
    }
    
    public void setYear(int year){
    
        this.year = year;
    
    }
    
    public int getFloatingPointOperationsPerSecond(){
    
        return floatingPointOperationsPerSecond;
    
    }
    
    public void setFloatingPointOperationsPerSecond(int floatingPointOperationsPerSecond){
    
        this.floatingPointOperationsPerSecond = floatingPointOperationsPerSecond;
    
    }
    
    @Override
    public String toString(){
    
        String consola = "";
        consola += "Entidad: " + entity + "\n";
        consola += "Código: " + code + "\n";
        consola += "Año: " + year + "\n";
        consola += "Operacion por segundo : " + floatingPointOperationsPerSecond + "\n";
        return consola;
    
    }
    
}