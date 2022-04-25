package es.julionieto.supercomputerpowerflops;

public class SupercomputerPowerFlop {
    
    private String entity=" ";
    private String code;
    private int year;
    private long floatingPointOperationsPerSecond;   

    public SupercomputerPowerFlop(String entity, String code, int year, long floatingPointOperationsPerSecond) {
        this.entity = entity;
        this.code = code;
        this.year = year;
        this.floatingPointOperationsPerSecond = floatingPointOperationsPerSecond;
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
    
    public long getFloatingPointOperationsPerSecond(){
    
        return floatingPointOperationsPerSecond;
    
    }
    
    public void setFloatingPointOperationsPerSecond(long floatingPointOperationsPerSecond){
    
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