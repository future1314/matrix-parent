package zhangyuyao.POI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

public class ReadExcel {

    public Map<String, Integer> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Integer> variables) {
        this.variables = variables;
    }

    public Map<String, RowNode> getRowValues() {
        return rowValues;
    }

    public void setRowValues(Map<String, RowNode> rowValues) {
        this.rowValues = rowValues;
    }

    /**
     * 保存第一行数据
     */
    private Map<String, Integer> variables = new LinkedHashMap<>();

    private Map<String, RowNode> rowValues = new LinkedHashMap<>();

    public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {

        InputStream inputStream = new FileInputStream("E:\\file\\input.xlsx");

        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

        ReadExcel readExcel = new ReadExcel();

        // 存储第一行数据
        readExcel.printFirstColumn(sheet);

        // 变量名处理
        readExcel.processVariableName();

        // 名称处理
        readExcel.processChineseName(sheet);

        // 类型处理
        readExcel.processDataType(sheet);

        // 是否必传
        readExcel.processNecessary(sheet);

        // 描述
        readExcel.processDescription(sheet);

        System.out.println(new Gson().toJson(readExcel.getRowValues()));

    }

    /**
     * 描述
     * 
     * @param sheet
     */
    private void processDescription(Sheet sheet) {
        List<String> keys = new ArrayList<>(variables.keySet());

        for (int i = 0; i < keys.size(); i++) {

            List<String> descriptions = new ArrayList<>();

            int j = sheet.getLastRowNum();

            if (i + 1 < keys.size()) {
                j = variables.get(keys.get(i + 1)) - 1;
            }

            for (int k = variables.get(keys.get(i)); k <= j; k++) {
                descriptions.add(sheet.getRow(k).getCell(4).getStringCellValue());
            }

            rowValues.get(keys.get(i)).setDescription(descriptions);
        }
    }

    /**
     * 是否必传
     * 
     * @param sheet
     */
    private void processNecessary(Sheet sheet) {
        variables.forEach((key, value) -> {
            String necessary = sheet.getRow(value).getCell(3).getStringCellValue();
            rowValues.get(key).setNecessary(necessary);
        });
    }

    /**
     * 变量类型
     *
     * @param sheet
     */
    private void processDataType(Sheet sheet) {
        variables.forEach((key, value) -> {
            String dataType = sheet.getRow(value).getCell(2).getStringCellValue();
            rowValues.get(key).setDataType(dataType);
        });
    }

    /**
     * 设置名称
     * 
     * @param sheet
     */
    private void processChineseName(Sheet sheet) {
        variables.forEach((key, value) -> {
            String chineseName = sheet.getRow(value).getCell(1).getStringCellValue();
            rowValues.get(key).setChineseName(chineseName);
        });
    }

    /**
     * 变量名处理
     */
    private void processVariableName() {
        variables.forEach((key, value) -> {
            RowNode rowNode = new RowNode();
            rowNode.setVariableName(key.substring(0, 1).toLowerCase() + key.substring(1));

            rowValues.put(key, rowNode);
        });
    }

    /**
     * 行值
     */
    private static class RowNode {
        private String       variableName;
        private String       chineseName;
        private String       dataType;
        private String       necessary;
        private List<String> description;

        public String getVariableName() {
            return variableName;
        }

        public void setVariableName(String variableName) {
            this.variableName = variableName;
        }

        public String getChineseName() {
            return chineseName;
        }

        public void setChineseName(String chineseName) {
            this.chineseName = chineseName;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getNecessary() {
            return necessary;
        }

        public void setNecessary(String necessary) {
            this.necessary = necessary;
        }

        public List<String> getDescription() {
            return description;
        }

        public void setDescription(List<String> description) {
            this.description = description;
        }
    }

    /**
     * 第一列
     */
    private static final int FIRST_COLUMN = 0;

    /**
     * 
     * @param sheet
     */
    private void printFirstColumn(Sheet sheet) {
        for (Row row : sheet) {
            String variable = row.getCell(0).getStringCellValue();
            if (!StringUtils.isEmpty(variable)) {
                variables.put(variable, row.getRowNum());
            }
        }
    }

    private String getMergedRegionValue(Sheet sheet, CellRangeAddress cellRangeAddress) {
        // 获取列表和行标
        int columnIndex = cellRangeAddress.getFirstColumn();
        int rowIndex = cellRangeAddress.getFirstRow();

        return sheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
    }

    /**
     * 获取单元格的值
     * @param cell
     * @return
     */
    public String getCellValue(Cell cell) {
        if (cell == null)
            return "";
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(cell.getBooleanCellValue());
        } else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getCellFormula();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(cell.getNumericCellValue());
        }
        return "";
    }

    /**
     * 合并单元格处理,获取合并行 
     * 
     * @param sheet
     * @return List<CellRangeAddress> 
     */
    public List<CellRangeAddress> getCombineCell(Sheet sheet) {
        List<CellRangeAddress> list = new ArrayList<>();

        //获得一个 sheet 中合并单元格的数量
        int counts = sheet.getNumMergedRegions();

        //遍历所有的合并单元格
        for (int i = 0; i < counts; i++) {

            //获得合并单元格保存进list中  
            CellRangeAddress ca = sheet.getMergedRegion(i);
            list.add(ca);
        }

        return list;
    }

    private int getRowNum(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet) {
        int xr = 0;
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        for (CellRangeAddress ca : listCombineCell) {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列  
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
                if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
                    xr = lastR;
                }
            }

        }
        return xr;

    }

    /**
     * 判断单元格是否为合并单元格，是的话则将单元格的值返回 
     * @param listCombineCell 存放合并单元格的list 
     * @param cell 需要判断的单元格 
     * @param sheet sheet 
     * @return
     */
    public String isCombineCell(List<CellRangeAddress> listCombineCell, Cell cell, Sheet sheet) throws Exception {
        int firstC = 0;
        int lastC = 0;
        int firstR = 0;
        int lastR = 0;
        String cellValue = null;
        for (CellRangeAddress ca : listCombineCell) {
            //获得合并单元格的起始行, 结束行, 起始列, 结束列  
            firstC = ca.getFirstColumn();
            lastC = ca.getLastColumn();
            firstR = ca.getFirstRow();
            lastR = ca.getLastRow();
            if (cell.getRowIndex() >= firstR && cell.getRowIndex() <= lastR) {
                if (cell.getColumnIndex() >= firstC && cell.getColumnIndex() <= lastC) {
                    Row fRow = sheet.getRow(firstR);
                    Cell fCell = fRow.getCell(firstC);
                    cellValue = getCellValue(fCell);
                    break;
                }
            } else {
                cellValue = "";
            }
        }
        return cellValue;
    }

    /**
     * 获取合并单元格的值   
     * @param sheet
     * @param row
     * @param column
     * @return
     */
    public String getMergedRegionValue(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    Row fRow = sheet.getRow(firstRow);
                    Cell fCell = fRow.getCell(firstColumn);
                    return getCellValue(fCell);
                }
            }
        }

        return null;
    }

    /**
     * 判断指定的单元格是否是合并单元格  
     * @param sheet
     * @param row 行下标  
     * @param column 列下标  
     * @return
     */
    private boolean isMergedRegion(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress range = sheet.getMergedRegion(i);
            int firstColumn = range.getFirstColumn();
            int lastColumn = range.getLastColumn();
            int firstRow = range.getFirstRow();
            int lastRow = range.getLastRow();
            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {
                    return true;
                }
            }
        }
        return false;
    }
}
