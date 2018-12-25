package cn.pinghu.springboot_web_jsp.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.math.BigDecimal;
import java.util.Date;

public class LoanInfo extends BaseRowModel {
    @ExcelProperty(index = 0)
    private String bankLoanId;

    @ExcelProperty(index = 1)
    private Long customerId;

    @ExcelProperty(index = 2,format = "yyyy/MM/dd")
    private Date loanDate;

    @ExcelProperty(index = 3)
    private BigDecimal quota;


    @Override
    public String toString() {
        return "LoanInfo{" +
                "bankLoanId='" + bankLoanId + '\'' +
                ", customerId=" + customerId +
                ", loanDate=" + loanDate +
                ", quota=" + quota +
                '}';
    }
}