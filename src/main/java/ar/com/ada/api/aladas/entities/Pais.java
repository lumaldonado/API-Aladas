package ar.com.ada.api.aladas.entities;

public class Pais {
    public enum PaisEnum{
        ARGENTINA(32), ESTADOS_UNIDOS(840), VENEZUELA(862), COLUMBIA(170);

        private final Integer value;

        private PaisEnum(Integer value){
            this.value = value;
        }

        public Integer getValue(){
            return value;
        }

        public static PaisEnum parse(Integer id){
            PaisEnum status = null;
            for(PaisEnum item : PaisEnum.values()){
                if (item.getValue().equals(id)){
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

    //FALTA ENUM DE TIPODOCUMENTO
    public enum TipoDocuEnum{
        DNI(1), PASAPORTE(2);

        private final Integer value;

        private TipoDocuEnum(Integer value){
            this.value = value;
        }

        public Integer getValue(){
            return value;
        }

        public static TipoDocuEnum parse(Integer id) {
            TipoDocuEnum status = null; // Default
            for (TipoDocuEnum item : TipoDocuEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

}
