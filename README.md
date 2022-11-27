# db_insight_display_program


> 데이터 공개 사이트에서 시간별 데이터나 년간 데이터를 찾아서 소스 테이터에서 통계정보를 제공하는 SQL 문장을 활용하여 정보를 display하는 Database Programming을 하여 제출하세요.


### 1. insight
노령인구 증가에 의한 사회복지의 현황과 노령인구 자활 필요성

### 2. 테이블 설계
![EDB5F781-9548-4770-9C35-99E4180327DE](https://user-images.githubusercontent.com/114554407/204111934-ff46a0e1-8312-4ea7-9fde-7e5fc348b1c9.jpg)

### 3. 수집데이터
- 서울특별시_자치구별 노령화지수 (추계인구) 통계 https://www.data.go.kr/data/15046993/fileData.do
- 서울시 노령연금 지급현황(연령별) 통계 https://data.seoul.go.kr/dataList/10086/S/2/datasetView.do
- 복지시설 목록
    - 전국경로우대지정업소표준데이터 https://www.data.go.kr/data/15034531/standard.do
    - 서울특별시_사회복지시설(자활시설) 목록 https://www.data.go.kr/data/15076879/fileData.do
    - 서울시 사회복지시설(자활시설) 목록 https://data.seoul.go.kr/dataList/OA-20413/S/1/datasetView.do
    - 서울시 사회복지시설(재가노인복지시설) 목록 https://data.seoul.go.kr/dataList/OA-20414/S/1/datasetView.do
    - 서울시 사회복지시설(노인의료복지시설) 목록 https://data.seoul.go.kr/dataList/OA-20413/S/1/datasetView.do
    - 서울시 사회복지시설(노인일자리지원기관) 목록 https://data.seoul.go.kr/dataList/OA-20414/S/1/datasetView.do
    - 서울시 사회복지시설(노인주거복지시설) 목록 https://data.seoul.go.kr/dataList/OA-20415/S/1/datasetView.do
    - 서울시 사회복지시설(노인여가복지시설) 목록 https://data.seoul.go.kr/dataList/OA-20412/S/1/datasetView.do
    - 서울시 사회복지시설(노인보호전문기관) 목록 https://data.seoul.go.kr/dataList/OA-20411/S/1/datasetView.do
    - 전국경로우대지정업소표준데이터 http://data.seoul.go.kr/dataList/OA-20424/S/1/datasetView.do
- 노인복지 생활시설 수 및 생활현황 https://kosis.kr/statHtml/statHtml.do?orgId=117&tblId=DT_117N_B00003
- OECD 노령화지수 https://kosis.kr/statHtml/statHtml.do?orgId=101&tblId=DT_2KAA202_OECD&conn_path=I2
