package com.jikjk.service;

import com.jikjk.entity.CloseWage;

/**
 * Created by lenovo on 2018/10/21.
 */
public interface CloseWageService {
    //��ӹ��ʽ���
    public void insert(CloseWage closeWage);
    //��ѯ�ϸ���Ա���Ľ��㹤��
    public CloseWage selectCloseWage(String monthWorkTime, int eId);
}
