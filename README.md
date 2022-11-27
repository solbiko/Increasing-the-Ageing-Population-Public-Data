# db_insight_display_program
Sprint boot + Mybatis + mariaDB + Thymeleaf

> 데이터 공개 사이트에서 시간별 데이터나 년간 데이터를 찾아서 소스 테이터에서 통계정보를 제공하는 SQL 문장을 활용하여 정보를 display하는 Database Programming을 하여 제출하세요.


## 1. insight
노령인구 증가에 의한 사회복지의 현황과 노령인구 자활 필요성

## 2. 테이블 설계
![EDB5F781-9548-4770-9C35-99E4180327DE](https://user-images.githubusercontent.com/114554407/204111934-ff46a0e1-8312-4ea7-9fde-7e5fc348b1c9.jpg)

## 3. 수집데이터
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
  
  
## 4. 데이터 조회
1. OECD 국가의 연도별 노령화 지수 조회 : 대한민국의 증가추세가 타 국가에 비해 가파른 편
    - 피봇테이블
    ![스크린샷 2022-11-27 오후 6 40 17](https://user-images.githubusercontent.com/114554407/204128614-e5fe0811-668c-4d97-a22b-5d3e59aceee1.png)
        ```sql
        SELECT
        *
        FROM(
          SELECT t.year,
            MAX(IF(t.country_code = 1409, t.aging_index, 0)) as 일본,
            MAX(IF(t.country_code = 1424, t.aging_index, 0)) as 대한민국,
            MAX(IF(t.country_code = 2400, t.aging_index, 0)) as 이스라엘,
            MAX(IF(t.country_code = 4214, t.aging_index, 0)) as 캐나다,
            MAX(IF(t.country_code = 4748, t.aging_index, 0)) as 미국,
            MAX(IF(t.country_code = 5235, t.aging_index, 0)) as 칠레,
            MAX(IF(t.country_code = 5247, t.aging_index, 0)) as 콜롬비아,
            MAX(IF(t.country_code = 5259, t.aging_index, 0)) as 코스타리카,
            MAX(IF(t.country_code = 5502, t.aging_index, 0)) as 멕시코,
            MAX(IF(t.country_code = 6139, t.aging_index, 0)) as 오스트레일리아,
            MAX(IF(t.country_code = 6547, t.aging_index, 0)) as 뉴질랜드,
            MAX(IF(t.country_code = 7142, t.aging_index, 0)) as 오스트리아,
            MAX(IF(t.country_code = 7163, t.aging_index, 0)) as 벨기에,
            MAX(IF(t.country_code = 7274, t.aging_index, 0)) as 체코,
            MAX(IF(t.country_code = 7277, t.aging_index, 0)) as 덴마크,
            MAX(IF(t.country_code = 7301, t.aging_index, 0)) as 에스토니아,
            MAX(IF(t.country_code = 7313, t.aging_index, 0)) as 핀란드,
            MAX(IF(t.country_code = 7315, t.aging_index, 0)) as 프랑스,
            MAX(IF(t.country_code = 7331, t.aging_index, 0)) as 독일,
            MAX(IF(t.country_code = 7340, t.aging_index, 0)) as 그리스,
            MAX(IF(t.country_code = 7376, t.aging_index, 0)) as 헝가리,
            MAX(IF(t.country_code = 7379, t.aging_index, 0)) as 아이슬란드,
            MAX(IF(t.country_code = 7394, t.aging_index, 0)) as 아일랜드,
            MAX(IF(t.country_code = 7403, t.aging_index, 0)) as 이탈리아,
            MAX(IF(t.country_code = 7436, t.aging_index, 0)) as 라트비아,
            MAX(IF(t.country_code = 7454, t.aging_index, 0)) as 리투아니아,
            MAX(IF(t.country_code = 7457, t.aging_index, 0)) as 룩셈부르크,
            MAX(IF(t.country_code = 7538, t.aging_index, 0)) as 네덜란드,
            MAX(IF(t.country_code = 7565, t.aging_index, 0)) as 노르웨이,
            MAX(IF(t.country_code = 7598, t.aging_index, 0)) as 폴란드,
            MAX(IF(t.country_code = 7601, t.aging_index, 0)) as 포르투갈,
            MAX(IF(t.country_code = 7646, t.aging_index, 0)) as 슬로바키아,
            MAX(IF(t.country_code = 7649, t.aging_index, 0)) as 슬로베니아,
            MAX(IF(t.country_code = 7664, t.aging_index, 0)) as 스페인,
            MAX(IF(t.country_code = 7700, t.aging_index, 0)) as 스웨덴,
            MAX(IF(t.country_code = 7703, t.aging_index, 0)) as 스위스,
            MAX(IF(t.country_code = 7736, t.aging_index, 0)) as 터키,
            MAX(IF(t.country_code = 7757, t.aging_index, 0)) as 영국
          FROM (
            select gai.year, cc.country, gai.country_code, gai.aging_index
            from global_aging_index gai
            left join country_code cc on cc.KOICA = gai.country_code
            group by gai.year, gai.country_code
          ) t
          group by t.year
        ) t2;
        ```

2. 지역구에 따른 연도별 평균, 최소, 최대 노령화 지수, 유소년, 노년 인구 부양비 합계 조회 : 연도별로 노령화 지수 증가 추세, 노년 인구 부양비 합계 증가 추세
    - 프로시저 호출 (파라미터 : 지역구 이름, null 값 일 때 전체 지역구 조회)
    ![스크린샷 2022-11-27 오후 6 42 06](https://user-images.githubusercontent.com/114554407/204128692-9e3af7c2-62ba-41db-adec-4b7d4ea7c8f5.png)
        ``` sql
            create
                definer = root@localhost procedure LOC_YEARLY_DATA(IN locName varchar(20))
            BEGIN
            select 
               ai.year,
               ai.loc_code,
               l.name,
               round(avg(ai.value))                        avg_ai,
               round(min(ai.value))                        min_ai,
               round(max(ai.value))                        max_ai,
               ifnull(round(sum(childhood_supporting_expense)),'')  sum_child_se,
               ifnull(round(sum(oldage_supporting_expense)),'')     sum_old_se
            from aging_index ai
            left outer join supporting_expense se on ai.year = se.year and ai.loc_code = se.loc_code
            left join loc_code l on l.code = ai.loc_code
            where ((locName is null and 1=1) or (locName is not null and name = locName))
            group by ai.loc_code, ai.year
            order by ai.loc_code, ai.year;
            END
        ```
        
3. 연도별, 시설별 노인복지 생활 시설 수 및 입소 현황 통계 : 연도별로 증가하는 추세 시설 수 및 입소 정원 또한 증가하는 추세

    - 연도별  
    ![스크린샷 2022-11-27 오후 6 44 26](https://user-images.githubusercontent.com/114554407/204128789-6740075b-1265-43d9-9fa0-328a957315a3.png)
        ``` sql
          select 
               ef.year,
               sum(cnt) ,
               sum(enter_cnt)
        from elderly_facility ef
        group by ef.year;
        ```

    - 연도, 시설별  
    ![스크린샷 2022-11-27 오후 6 46 39](https://user-images.githubusercontent.com/114554407/204128944-93302889-dece-45d6-9d71-73d39e3238e7.png)
        ``` sql
         select
            ef.year,
            ef.type,
            (select ft.type from facilitiy_type ft where ft.id = ef.type) type_name,
           sum(cnt) ,
           sum(enter_cnt)
        from elderly_facility ef
        group by ef.year, ef.type;
        ```
     
4. 연도, 연금 타입, 성별, 나이에 따른 노령연금 지급 현황 : 연도별 노령 연급 지급액이 증가하는 추세
    - 윈도우함수는 Group By와 비슷하게 데이터를 그룹화하여 집계해준다. 하지만 Group By는 집계된 결과만 보여주는 반면, 윈도우함수는 기존 데이터에 집계된 값을 추가하여 나타낸다.
    - group by
    ![스크린샷 2022-11-27 오후 8 39 00](https://user-images.githubusercontent.com/114554407/204133240-5cf4c1b5-dd63-4fcb-afa8-3ecc6a8849bf.png)

        ``` sql
         -- 나이를 조회 할 수 없고 집계된 데이터를 조회한다.
        select
          op.year,
          op.type,
          pt.name,
          if(op.gender = "M", "남", "여") gender,
          if(op.age = 54, "54세 이하", op.age) age,
          sum(op.payments) sum_payments,
          sum(op.pensioner_num) sum_pensioner_num
        from oldage_pension op left join pension_type pt on pt.idx = op.type
        group by op.year, op.type, op.gender;
        ```
    - 윈도우함수
    ![스크린샷 2022-11-27 오후 8 30 50](https://user-images.githubusercontent.com/114554407/204133251-bf6f8148-0c27-48b8-ad1b-abd80e08d95d.png)

        ``` sql
        -- 나이를 포함하여 집계된 데이터를 조회한다.
        select 
        op.year,
        op.type,
        pt.name,
        if(op.gender = "M", "남", "여") gender,
        if(op.age = 54, "54세 이하", op.age) age,
        sum(op.payments) OVER (PARTITION BY op.year, op.type, op.gender) sum_payments,
        sum(op.pensioner_num) OVER (PARTITION BY op.year, op.type, op.gender) sum_pensioner_num
        from oldage_pension op left join pension_type pt on pt.idx = op.type;
        ```
## 5. 결론  
OECD 국가별 연도별 노령화 지수에 따르면 대한민국의 노령화는 가속화되고 있다. 연도별 노인 복지 시설 수 및 입소 정원과 노년 인구 부양비, 노령 연급 지급액이 증가하는 추세를 보인다. 따라서 급격히 증가한 노령화 지수 따라 노년인구의 자활 필요성이 대두되고 있다.

