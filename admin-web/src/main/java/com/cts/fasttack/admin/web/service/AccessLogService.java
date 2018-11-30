package com.cts.fasttack.admin.web.service;


import com.cts.fasttack.admin.web.data.dict.AccessType;
import com.cts.fasttack.admin.web.data.dict.ItemType;
import com.cts.fasttack.admin.web.data.dto.AccessLogDto;
import com.cts.fasttack.admin.web.data.filter.AccessLogFilter;
import com.cts.fasttack.common.core.list.QueryResult;

public interface AccessLogService {

    AccessLogDto save(AccessLogDto dto);

    QueryResult<AccessLogDto> listPaged(AccessLogFilter filter);

    /**
     * Создает конструктор записи в лог доступа
     */
    Builder create();

    class Builder {

        private final AccessLogDto dto;

        private final AccessLogService service;

        public Builder(AccessLogService accessLogService) {
            service = accessLogService;
            dto = new AccessLogDto();
        }

        /**
         * Сохраняет запись
         */
        public void save(){
            service.save(dto);
        }

        /**
         * Тип доступа (чтение/редактировнаие)
         */
        public Builder type(AccessType type){
            dto.setAccessType(type);
            return this;
        }

        /**
         * Тип сущности, к которой получен доступ
         */
        public Builder item(ItemType type){
            dto.setItemType(type);
            return this;
        }

        /**
         * Идентификатор сущности, к которой получен доступ
         */
        public Builder id(String id){
            dto.setItemId(id);
            return this;
        }

        /**
         * Идентификатор сущности, к которой получен доступ
         */
        public Builder id(Object id){
            dto.setItemId(String.valueOf(id));
            return this;
        }

        /**
         * Измененные поля сущности
         */
        public Builder fields(String...args){
            if(args != null){
                dto.setField1(args.length > 0 ? args[0] : null);
                dto.setField2(args.length > 1 ? args[1] : null);
                dto.setField3(args.length > 2 ? args[2] : null);
                dto.setField4(args.length > 3 ? args[3] : null);
                dto.setField5(args.length > 4 ? args[4] : null);
            }else{
                dto.setField1(null);
                dto.setField2(null);
                dto.setField3(null);
                dto.setField4(null);
                dto.setField5(null);
            }
            return this;
        }

    }
}
