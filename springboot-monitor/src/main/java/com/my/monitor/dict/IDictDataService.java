package com.my.monitor.dict;

import com.my.monitor.domain.DictData;

import java.util.List;

/**
 * 字典 业务层
 * 
 * @author ruoyi
 */
public interface IDictDataService
{

    /**
     * 根据字典类型查询字典数据
     * 
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<DictData> selectDictDataByType(String dictType);

    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(String dictType, String dictValue);


}
