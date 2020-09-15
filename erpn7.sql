--N7 TEAM PROJECT155
--ERP DB

--테이블 관련
-->>홈페이지 테이블

--상담게시판88888
CREATE TABLE CONSULTING_BOARD(
  CB_NUM NUMBER(5,0) NOT NULL,
  CB_TYPE NCHAR(1) NOT NULL,
  CB_WRITER NVARCHAR2(20) NOT NULL,
  CB_PASSWORD NVARCHAR2(20) NOT NULL,
  CB_TITLE NVARCHAR2(30) NOT NULL,
  CB_CONTENTS NCLOB NOT NULL,
  CONSTRAINT CB_NUM_PK PRIMARY KEY (CB_NUM)
);

--상담게시판 답글
CREATE TABLE BOARD_REPLY(
  BR_NUM NUMBER(5,0) NOT NULL,
  BR_CONTENTS NCLOB NOT NULL,
  CONSTRAINT BR_NUM_FK FOREIGN KEY (BR_NUM) REFERENCES CONSULTING_BOARD (CB_NUM)
);

--회사
CREATE TABLE COMPANY(
  C_CODE NVARCHAR2(20) NOT NULL,
  C_NAME NVARCHAR2(30) NOT NULL,
  C_CEO NVARCHAR2(10) NOT NULL,
  C_PHONENUM NVARCHAR2(11) NOT NULL,
  C_KIND NVARCHAR2(20) NOT NULL, --업태
  C_KIND2 NVARCHAR2(20) NOT NULL, --종류
  C_ADDR NVARCHAR2(50) NOT NULL,
  C_VALUE NVARCHAR2(20) NOT NULL,
  C_MONEY NUMBER(15, 0) NOT NULL,
  CONSTRAINT C_CODE_PK PRIMARY KEY (C_CODE)
);
--회사없이 가입할경우 기본값 입력되기 위한 더미데이터(홈페이지 회사)
INSERT INTO COMPANY
  VALUES('N7', 'N7PROJECT', 'N7', '01011112222', 'ERP', 'ERP',
  'INCHEON', 'VALUE', '0');

--홈페이지회원
CREATE TABLE MEMBER(
  M_ID NVARCHAR2(20) NOT NULL,
  M_PW NVARCHAR2(20) NOT NULL,
  M_NAME NVARCHAR2(10) NOT NULL,
  M_ADDRESS NVARCHAR2(50) NOT NULL,
  M_PHONENUM NVARCHAR2(11) NOT NULL, -- 01012345678형식(하이픈없음)
  M_PHOTO NVARCHAR2(100) NOT NULL,
  M_BIRTH NVARCHAR2(20) NOT NULL, --DEFAULT SYSDATE 사용하지않아서 편한 NVARCHAR2(20)F형식으로 함
  M_EMAIL NVARCHAR2(40) NOT NULL,
  M_GRADE NCHAR(1) NOT NULL, -- 0: 일반회원 1:ERP매니저회원 2:ADMIN
  M_CCODE NVARCHAR2(20),
  CONSTRAINT M_ID_PK PRIMARY KEY (M_ID),
  CONSTRAINT M_CCODE_FK FOREIGN KEY (M_CCODE) REFERENCES COMPANY (C_CODE)
);

--회사 ERP 기능
CREATE TABLE ERP_FUNCTION(
  F_CCODE NVARCHAR2(20) NOT NULL,
  F_FUNCTIONS NVARCHAR2(20) NOT NULL,
  CONSTRAINT F_CCODE_FK FOREIGN KEY (F_CCODE) REFERENCES COMPANY (C_CODE)
);


-->>ERP기능 테이블
-->>>필수테이블

--인사카드
CREATE TABLE HR_CARD(
  HC_HRCODE NVARCHAR2(20) NOT NULL, --HC_JOINDATE + SEQ 로 자동생성
  HC_CCODE NVARCHAR2(20) NOT NULL,
  HC_ID NVARCHAR2(20) NOT NULL,
  HC_DEPT NVARCHAR2(20) NOT NULL,
  HC_POSITION NVARCHAR2(20) NOT NULL,
  HC_JOINDATE NVARCHAR2(20) NOT NULL,
  HC_WORK NCHAR(1) DEFAULT 0 NOT NULL ,
  HC_STATUS NCHAR(1) DEFAULT 0 NOT NULL,
  HC_HOLYNUM NUMBER(2,0) DEFAULT 0 NOT NULL,
  CONSTRAINT HC_HRCARD_PK PRIMARY KEY (HC_HRCODE, HC_CCODE),
  CONSTRAINT HC_HRCARD_FK1 FOREIGN KEY (HC_ID) REFERENCES MEMBER (M_ID),
  CONSTRAINT HC_HRCARD_FK2 FOREIGN KEY (HC_DEPT, HC_POSITION) REFERENCES HR_DEPT (HD_DEPT, HD_POSITION),
  CONSTRAINT HC_HRCARD_FK3 FOREIGN KEY (HC_CCODE) REFERENCES COMPANY (C_CODE)
);

--부서/직책
CREATE TABLE HR_DEPT(
  HDP_DEPT NVARCHAR2(20) NOT NULL,
  HDP_POSITION NVARCHAR2(20) NOT NULL,
  HDP_CCODE NVARCHAR2(20) NOT NULL,
  HDP_PAY NUMBER(15,0),
  HDP_NUM NVARCHAR2(5),
  HDP_AUTH NCHAR(1) DEFAULT 0 NOT NULL, --사원권한기능 0 : 일반사원 1 : 팀장급 2: 사장급
  CONSTRAINT HC_DEPT_PK PRIMARY KEY (HD_DEPT, HD_POSITION),
  CONSTRAINT HC_DEPT_FK FOREIGN KEY (HD_CCODE) REFERENCES COMPANY (C_CODE)
);

--사원 권한/기능
CREATE TABLE HR_AUTORITY(
  HAT_HRCODE NVARCHAR2(20) NOT NULL,
  HAT_CCODE NVARCHAR2(20) NOT NULL,
  HAT_AUTH NVARCHAR2(20) NOT NULL,
  CONSTRAINT HR_AUTORITY_FK FOREIGN KEY (HAT_HRCODE, HAT_CCODE) REFERENCES HR_CARD (HC_HRCODE, HC_CCODE)
);

--결재문서양식
CREATE TABLE APPROVALDOCU(
  AP_DOCUNUM NVARCHAR2(10) NOT NULL, --NCHAR(5)였는데 넉넉하게 바꿈
  AP_CCODE NVARCHAR2(20) NOT NULL,
  AP_DOCUNAME NVARCHAR2(20) NOT NULL,
  AP_FROMAPPROVER NVARCHAR2(20) NOT NULL,
  AP_TOAPPROVER NVARCHAR2(20) NOT NULL,
  AP_DATE DATE DEFAULT SYSDATE NOT NULL,
  AP_STATUS NCHAR(1) DEFAULT 0 NOT NULL,
  CONSTRAINT APPROVALDOCU_PK PRIMARY KEY (AP_DOCUNUM, AP_CCODE),
  CONSTRAINT APPROVALDOCU_FK FOREIGN KEY (AP_CCODE) REFERENCES COMPANY (C_CODE)
);

--거래처 등록테이블
CREATE TABLE AC_COMPANYLIST(
  CL_CODE NVARCHAR2(20) NOT NULL,
  CL_CCODE NVARCHAR2(20) NOT NULL,
  CL_NAME NVARCHAR2(20) NOT NULL,
  CL_COMNUM NVARCHAR2(20) NOT NULL, --사업자번호
  CL_COMNUM2 NVARCHAR2(20) NOT NULL, --종사장번호
  CL_CEO NVARCHAR2(20) NOT NULL,
  CL_EMPLOYEE NVARCHAR2(20) NOT NULL, --담당직원
  CL_PHONE NVARCHAR2(20) NOT NULL,
  CL_PHONE2 NVARCHAR2(20) NOT NULL,
  CL_FAX NVARCHAR2(20) NOT NULL,
  CL_EMAIL NVARCHAR2(50) NOT NULL,
  CL_ADDR NVARCHAR2(100) NOT NULL, --우편번호 + 주소 통합시킴
  CL_KIND NVARCHAR2(20) NOT NULL, --업태
  CL_KIND2 NVARCHAR2(20) NOT NULL, -- 종류
  CL_KIND3 NVARCHAR2(20) NOT NULL, -- 분류
  CL_BANK NVARCHAR2(20) NOT NULL,
  CL_BANKHOLDER NVARCHAR2(20) NOT NULL, --예금주
  CL_MEMO NVARCHAR2(40),
  CONSTRAINT AC_COMPANYLIST_PK PRIMARY KEY (CL_CODE, CL_CCODE),
  CONSTRAINT AC_COMPANYLLIST_FK FOREIGN KEY (CL_CCODE) REFERENCES COMPANY (C_CODE)
);


-->>>인사기능

--학력
CREATE TABLE HR_ACADEMIC(
  HAC_NUM NUMBER(5,0) NOT NULL,
  HAC_CCODE NVARCHAR2(20) NOT NULL,
  HAC_HRCODE NVARCHAR2(20) NOT NULL,
  HAC_SCHOOL NVARCHAR2(20) NOT NULL,
  HAC_MAJOR NVARCHAR2(20) NOT NULL,
  HAC_YEAR NVARCHAR2(20) NOT NULL,
  CONSTRAINT HR_ACADEMIC_PK PRIMARY KEY (HAC_NUM, HAC_CCODE),
  CONSTRAINT HR_ACADEMIC_FK FOREIGN KEY (HAC_CCODE, HAC_HRCODE) REFERENCES HR_CARD (HC_CCODE, HC_HRCODE)
);


--이력
CREATE TABLE HR_CAREER(
  HCR_NUM NUMBER(5,0) NOT NULL,
  HCR_CCODE NVARCHAR2(20) NOT NULL,
  HCR_HRCODE NVARCHAR2(20) NOT NULL,
  HCR_NAME NVARCHAR2(20) NOT NULL,
  HCR_STARTPERIOD NVARCHAR2(20) NOT NULL,
  HCR_ENDPERIOD NVARCHAR2(20) NOT NULL,
  HCR_POSITION NVARCHAR2(20) NOT NULL,
  HCR_CONTENT NCLOB,
  CONSTRAINT HR_CAREER_PK PRIMARY KEY (HCR_NUM, HCR_CCODE, HCR_HRCODE),
  CONSTRAINT HR_CAREER_FK FOREIGN KEY (HCR_CCODE, HCR_HRCODE) REFERENCES HR_CARD (HC_CCODE, HC_HRCODE)
);

--자격증
CREATE TABLE HR_CERTIFICATION(
  HCT_NUM NUMBER(5,0) NOT NULL,
  HCT_CCODE NVARCHAR2(20) NOT NULL,
  HCT_HRCODE NVARCHAR2(20) NOT NULL,
  HCT_NAME NVARCHAR2(20) NOT NULL,
  HCT_AGENCY NVARCHAR2(20) NOT NULL,
  HCT_DATE NVARCHAR2(20) NOT NULL,
  CONSTRAINT HR_CERTIFICATION_PK PRIMARY KEY (HCT_NUM, HCT_CCODE),
  CONSTRAINT HR_CERTIFICATION_FK FOREIGN KEY (HCT_CCODE, HCT_HRCODE) REFERENCES HR_CARD (HC_CCODE, HC_HRCODE)
);


-->>>급여
--급여명세서
CREATE TABLE HR_PAYROLL(
  HP_PAYDATE NVARCHAR2(20) NOT NULL,
  HP_CCODE NVARCHAR2(20) NOT NULL,
  HP_HRCODE NVARCHAR2(20) NOT NULL,
  HP_TAX NUMBER(15,0),
  HP_INCEN NUMBER(15,0),
  HP_INSURANCE NUMBER(15,0),
  HP_REALMONEY NUMBER(15,0) NOT NULL,
  CONSTRAINT HR_PAYROLL_PK PRIMARY KEY (HP_PAYDATE, HP_CCODE, HP_HRCODE),
  CONSTRAINT HR_PAYROLL_FK FOREIGN KEY (HP_CCODE, HP_HRCODE) REFERENCES HR_CARD (HC_CCODE, HC_HRCODE)
);
--공제사항
CREATE TABLE HR_DEDUCTION(
  HDD_CCODE NVARCHAR2(20) NOT NULL,
  HDD_NAME NVARCHAR2(20) NOT NULL,
  HDD_AMOUNT NUMBER(15,0),
  CONSTRAINT HDD_DEDUCTION_PK PRIMARY KEY (HDD_CCODE,HDD_NAME,HDD_AMOUNT),
  CONSTRAINT HDD_DEDUCTION_FK FOREIGN KEY (HDD_CCODE) REFERENCES COMPANY (C_CODE)
);

-->>>근태
--출/퇴근테이블
CREATE TABLE HR_ATTENDANCE(
  HA_CCODE NVARCHAR2(20) NOT NULL,
  HA_HRCODE NVARCHAR2(20) NOT NULL,
  HA_TIME DATE DEFAULT SYSDATE NOT NULL,
  HA_TYPE NCHAR(1) NOT NULL,
  CONSTRAINT HR_ATTENDANCE_FK FOREIGN KEY (HA_CCODE, HA_HRCODE) REFERENCES HR_CARD (HC_CCODE, HC_HRCODE)
);

--휴가신청
CREATE TABLE HR_APPLYHOLIDAY(
  HAP_DOCUNUM NVARCHAR2(10) NOT NULL, --문서번호 겸 휴가신청번호
  HAP_CCODE NVARCHAR2(20) NOT NULL,
  HAP_HRCODE NVARCHAR2(20) NOT NULL,
  HAP_DOCUNAME NVARCHAR2(20) NOT NULL,
  HAP_FROMAPPROVER NVARCHAR2(20) NOT NULL,
  HAP_TOAPPROVER NVARCHAR2(20) NOT NULL,
  HAP_APPLYDATE DATE DEFAULT SYSDATE NOT NULL, --문서신청일
  HAP_TYPE NVARCHAR2(20) NOT NULL, --휴가타입
  HAP_REASON NCLOB,
  HAP_STARTDAY NVARCHAR2(20) NOT NULL,
  HAP_ENDDAY NVARCHAR2(20) NOT NULL,
  HAP_STATUS NCHAR(1) DEFAULT 0 NOT NULL,
  CONSTRAINT HR_APPLYHOLIDAY_PK PRIMARY KEY (HAP_DOCUNUM, HAP_CCODE),
  CONSTRAINT HR_APPLYHOLIDAY_FK1 FOREIGN KEY (HAP_DOCUNUM, HAP_CCODE) REFERENCES APPROVALDOCU (AP_DOCUNUM, AP_CCODE),
  CONSTRAINT HR_APPLYHOLIDAY_FK2 FOREIGN KEY (HAP_CCODE, HAP_HRCODE) REFERENCES HR_CARD (HC_CCODE, HC_HRCODE)
);

-->>영업관련

--수주
CREATE TABLE B_ORDER(
  BO_NUM NVARCHAR2(10) NOT NULL,
  BO_CCODE NVARCHAR2(20) NOT NULL,
  BO_CLCODE NVARCHAR2(20) NOT NULL,
  BO_UNIT NVARCHAR2(20) NOT NULL,
  BO_ORDERDATE NVARCHAR2(20) NOT NULL,
  BO_DUEDATE NVARCHAR2(20) NOT NULL,
  BO_MANAGER NVARCHAR2(20) NOT NULL,
  BO_DETP NVARCHAR2(20) NOT NULL,
  BO_PRONUM NVARCHAR2(20) NOT NULL,
  BO_PROQUANTITY NUMBER(10,0) NOT NULL,
  BO_PROSALESAMOUNT NUMBER(15,0) NOT NULL,
  BO_ORDERBUDGET NUMBER(15,0) NOT NULL,
  CONSTRAINT B_ORDER_PK PRIMARY KEY (BO_NUM, BO_CCODE),
  CONSTRAINT B_ORDER_FK FOREIGN KEY (BO_CLCODE, BO_CCODE) REFERENCES AC_COMPANYLIST (CL_CODE, CL_CCODE)
);

--미수금
CREATE TABLE B_UNCOLLECTEDMONEY(
  BU_CCODE NVARCHAR2(20) NOT NULL,
  BU_ORDERNUM NVARCHAR2(10) NOT NULL,
  BU_ITCODE NVARCHAR2(20),
  BU_CLCODE NVARCHAR2(20) NOT NULL,
  BU_QUANTITY NUMBER(10,0) NOT NULL,
  BU_BASEDATE NVARCHAR2(20) NOT NULL,
  BU_PERFORMANCESTANDARD NVARCHAR2(20) NOT NULL,
  BU_PREMONTHS NUMBER(15,0) NOT NULL,
  BU_THISMONTHMONEY NUMBER(15,0) NOT NULL,
  BU_CURRENTUNCOLLECTEDMONEY NUMBER(15,0) NOT NULL,
  BU_SHIPPINGREQUESTDATE NVARCHAR2(20) NOT NULL,
  CONSTRAINT B_UNCOLLECTEDMONEY_PK PRIMARY KEY (BU_CCODE, BU_SHIPPINGREQUESTNUM, BU_ORDERNUM, BU_CLCODE),
  CONSTRAINT B_UNCOLLECTEDMONEY_FK1 FOREIGN KEY (BU_ORDERNUM, BU_CCODE) REFERENCES B_ORDER (BO_NUM, BO_CCODE),
  CONSTRAINT B_UNCOLLECTEDMONEY_FK2 FOREIGN KEY (BU_ITCODE, BU_CCODE) REFERENCES S_ITEMCODE (IT_CODE, IT_CPCODE)
);

--영업활동
CREATE TABLE B_ACTIVITES(
  BA_OCODE NVARCHAR2(10) NOT NULL,
  BA_CCODE NVARCHAR2(20) NOT NULL,
  BA_HRCODE NVARCHAR2(20) NOT NULL,
  BA_CLCODE NVARCHAR2(20) NOT NULL,
  BA_UNIT NVARCHAR2(20) NOT NULL,
  BA_PERIOD NVARCHAR2(20) NOT NULL,
  BA_ANALYSISSTANDARD NVARCHAR2(20) NOT NULL,
  BA_CONTENT NCLOB NOT NULL,
  BA_DATE NVARCHAR2(20) NOT NULL,
  BA_ENDDATE NVARCHAR2(20),
  BA_ESTIMATEDSALESAMOUNT NUMBER(15,0) NOT NULL,
  BA_ACTUALSALESAMOUNT NUMBER(15,0) NOT NULL,
  BA_SORTATION NVARCHAR2(20) NOT NULL,
  BA_DETAILS NVARCHAR2(20) NOT NULL,
  BA_MEMO NCLOB,
  CONSTRAINT B_ACTIVITES_PK PRIMARY KEY (BA_OCODE, BA_CCODE, BA_CLCODE, BA_HRCODE),
  CONSTRAINT B_ACTIVITES_FK1 FOREIGN KEY (BA_HRCODE, BA_CCODE) REFERENCES HR_CARD (HC_HRCODE, HC_CCODE),
  CONSTRAINT B_ACTIVITES_FK2 FOREIGN KEY (BA_CLCODE, BA_CCODE) REFERENCES AC_COMPANYLIST (CL_CODE, CL_CCODE)
);

--출하결재요청
CREATE TABLE B_SHIPMENT(
  BS_DOCUNUM NVARCHAR2(10) NOT NULL, --문서번호 겸 출하번호
  BS_CCODE NVARCHAR2(20) NOT NULL,
  BS_BONUM NVARCHAR2(10) NOT NULL,
  BS_ITCODE NVARCHAR2(20) DEFAULT 'NO_STOCK' NOT NULL, --재고테이블이 없을 경우 DEFAULT 입력 후 PRONAME에 상품명입력
  BS_CLCODE NVARCHAR2(20) NOT NULL,
  BS_NAME NVARCHAR2(20) NOT NULL,
  BS_APPROVER1 NVARCHAR2(20) NOT NULL,
  BS_APPROVER2 NVARCHAR2(20) NOT NULL,
  BS_APPROVER3 NVARCHAR2(20) NOT NULL,
  BS_DATE NVARCHAR2(20) NOT NULL,
  BS_UNIT NUMBER(15,0) NOT NULL,
  BS_QUANTITY NUMBER(15,0) NOT NULL,
  BS_PRICE NUMBER(15,0) NOT NULL,
  BS_STATUS NCHAR(1) DEFAULT 0 NOT NULL,
  BS_PRONAME NVARCHAR2(20) DEFAULT 'REF_ITCODE' NOT NULL, --재고테이블이 있을 경우 PRONAME은 DEFAULT값, 상품명은 ITCODE로 참조
  CONSTRAINT B_SHIPMENT_PK PRIMARY KEY (BS_DOCUNUM, BS_CCODE, BS_BONUM, BS_CLCODE),
  CONSTRAINT B_SHIPMENT_FK1 FOREIGN KEY (BS_DOCUNUM, BS_CCODE) REFERENCES APPROVALDOCU (AP_DOCUNUM, AP_CCODE),
  CONSTRAINT B_SHIPMENT_FK2 FOREIGN KEY (BS_BONUM, BS_CCODE) REFERENCES B_ORDER (BO_NUM, BO_CCODE),
  CONSTRAINT B_SHIPMENT_FK3 FOREIGN KEY (BS_CLCODE, BS_CCODE) REFERENCES AC_COMPANYLIST (CL_CODE, CL_CCODE)
);


-->>재고 관련
--분류명
CREATE TABLE S_CATEGORY(
  CT_CODE NVARCHAR2(20) NOT NULL,
  CT_CPCODE NVARCHAR2(20) NOT NULL,
  CT_NAME NVARCHAR2(20) NOT NULL,
  CONSTRAINT S_CATEGORY_PK PRIMARY KEY (CT_CODE, CT_CPCODE),
  CONSTRAINT S_CATEGORY_FK FOREIGN KEY (CT_CPCODE) REFERENCES COMPANY (C_CODE)
);

--품목코드
CREATE TABLE S_ITEMCODE(
  IT_CODE NVARCHAR2(20) NOT NULL,
  IT_CPCODE NVARCHAR2(20) NOT NULL,
  IT_CCODE NVARCHAR2(20) NOT NULL,
  IT_PNAME NVARCHAR2(20) NOT NULL,
  IT_SIZE NVARCHAR2(20) NOT NULL,
  IT_UNIT NUMBER(10,0) NOT NULL,
  IT_PSTOCK NUMBER(10,0) NOT NULL,
  CONSTRAINT S_ITEMCODE_PK PRIMARY KEY (IT_CODE, IT_CPCODE),
  CONSTRAINT S_ITEMCODE_FK FOREIGN KEY (IT_CCODE, IT_CPCODE) REFERENCES S_CATEGORY (CT_CODE, CT_CPCODE)
);

--입고/출고
CREATE TABLE S_IEPORT(
  IE_SEQNUM NVARCHAR2(10) NOT NULL,
  IE_CPCODE NVARCHAR2(20) NOT NULL,
  IE_DATE DATE DEFAULT SYSDATE NOT NULL,
  IE_HRCODE NVARCHAR2(20) NOT NULL,
  IE_PNUM NVARCHAR2(20) NOT NULL,
  IE_CODE NVARCHAR2(20) NOT NULL,
  IE_ETC NVARCHAR2(20),
  IE_STATUS NCHAR(1) DEFAULT 0 NOT NULL,
  IE_CLCODE NVARCHAR2(20) NOT NULL,
  IE_OCODE NVARCHAR2(10),
  CONSTRAINT S_IEPORT_PK PRIMARY KEY (IE_SEQNUM, IE_CPCODE),
  CONSTRAINT S_IEPORT_FK1 FOREIGN KEY (IE_HRCODE, IE_CPCODE) REFERENCES HR_CARD (HC_HRCODE, HC_CCODE),
  CONSTRAINT S_IEPORT_FK2 FOREIGN KEY (IE_CLCODE, IE_CPCODE) REFERENCES AC_COMPANYLIST (CL_CODE, CL_CCODE),
  CONSTRAINT S_IEPORT_FK3 FOREIGN KEY (IE_OCODE, IE_CPCODE) REFERENCES O_ORDER (O_CODE, O_CCODE)
);

-->>구매관련
--구매 (계획서)
CREATE TABLE O_PURCHASEPROGRAM(
  P_DOCUMENTCODE NVARCHAR2(10) NOT NULL, --구매번호(겸 문서번호)
  P_CCODE NVARCHAR2(20) NOT NULL,
  P_TITLE NVARCHAR2(20) NOT NULL,
  P_DAY NVARCHAR2(20) NOT NULL,
  P_CLCODE NVARCHAR2(20) NOT NULL, --거래처 코드
  P_DATE NVARCHAR2(20) NOT NULL, --DATE형식이였는데 NVARCHAR2(20)로 바꿨음 알아서수정
  P_BUDGET NUMBER(15, 0) NOT NULL,
  P_USE NVARCHAR2(40) NOT NULL,
  P_WRITER NVARCHAR2(20) NOT NULL, --기안문작성자
  P_ETC NVARCHAR2(100), --기타사항
  P_DUEDATE NVARCHAR2(20) NOT NULL,
  P_STATE NCHAR(1) DEFAULT 0 NOT NULL,
  P_APPROVER1 NVARCHAR2(20) NOT NULL,
  P_APPORVER2 NVARCHAR2(20) NOT NULL,
  CONSTRAINT O_PURCHASEPROGRAM_PK PRIMARY KEY (P_DOCUMENTCODE, P_CCODE),
  CONSTRAINT O_PURCHASEPROGRAM_FK FOREIGN KEY (P_DOCUMENTCODE, P_CCODE) REFERENCES APPROVALDOCU (AP_DOCUNUM, AP_CCODE)
);

--구매상세리스트
CREATE TABLE O_PURCHASELIST(
  P_DOCUMENTCODE NVARCHAR2(10) NOT NULL,
  P_CCODE NVARCHAR2(20) NOT NULL,
  P_PRODUCTNUM NVARCHAR2(10) NOT NULL, --제품일련번호
  P_ITCODE NVARCHAR2(20),
  P_UNLIT NUMBER(15,0) NOT NULL,
  P_AMOUNT NUMBER(10,0) NOT NULL,
  CONSTRAINT O_PURCHASELIST_FK1 FOREIGN KEY (P_DOCUMENTCODE, P_CCODE) REFERENCES O_PURCHASEPROGRAM (P_DOCUMENTCODE, P_CCODE),
  CONSTRAINT O_PURCHASELIST_FK2 FOREIGN KEY (P_ITCODE, P_CCODE) REFERENCES S_ITEMCODE (IT_CODE, IT_CPCODE)
);

--발주
CREATE TABLE O_ORDER(
  O_CODE NVARCHAR2(10) NOT NULL, --발주번호
  O_DOCUMENTCODE NVARCHAR2(10) NOT NULL, --구매번호(문서번호)
  O_CCODE NVARCHAR2(20) NOT NULL,
  O_DATE NVARCHAR2(20) NOT NULL, --납기일
  O_DAY NVARCHAR2(20) NOT NULL, --발주일자 SYSDATE 사용할꺼면 DATE형식으로 바꿔서 해
  CONSTRAINT O_ORDER_PK PRIMARY KEY (O_CODE, O_CCODE),
  CONSTRAINT O_ORDER_FK FOREIGN KEY (O_DOCUMENTCODE, O_CCODE) REFERENCES O_PURCHASEPROGRAM (P_DOCUMENTCODE, P_CCODE)
);

--반품
CREATE TABLE O_RETURNPROGRAM(
  R_DOCUMENTCODE NVARCHAR2(10) NOT NULL, --반품번호(겸 문서번호)
  R_CCODE NVARCHAR2(20) NOT NULL,
  R_IESEQNUM NVARCHAR2(10), --입/출고번호
  R_TYPE NVARCHAR2(20) NOT NULL, --반품유형
  R_ITCODE NVARCHAR2(20), --품목코드
  R_AMOUNT NUMBER(10, 0), --반품수량
  R_POINT NVARCHAR2(30),
  R_NAME NVARCHAR2(20) NOT NULL, --기안문 작성자
  R_DAY DATE DEFAULT SYSDATE NOT NULL, --DATE형식임
  R_ETC NCLOB, --기타사항
  R_NOTE NCLOB, --비고
  R_EMAIL NVARCHAR2(50) NOT NULL,
  R_REASON NCLOB NOT NULL, --사유
  R_STATE NCHAR(1) DEFAULT 0 NOT NULL, --상태코드
  R_APPROVER1 NVARCHAR2(20) NOT NULL,
  R_APPROVER2 NVARCHAR2(20) NOT NULL, --결재자1, 2
  CONSTRAINT O_RETURNPROGRAM_PK PRIMARY KEY (R_DOCUMENTCODE, R_CCODE),
  CONSTRAINT O_RETURNPROGRAM_FK1 FOREIGN KEY (R_DOCUMENTCODE, R_CCODE) REFERENCES APPROVALDOCU (AP_DOCUNUM, AP_CCODE),
  CONSTRAINT O_RETURNPROGRAM_FK2 FOREIGN KEY (R_IESEQNUM, R_CCODE) REFERENCES S_IEPORT (IE_SEQNUM, IE_CPCODE)
);


-->>회계
--분개전표결재안
CREATE TABLE AC_JNOB(
  J_CCODE NVARCHAR2(20) NOT NULL,
  J_DOCUNUM NVARCHAR2(10) NOT NULL, --문서번호(겸 전표코드)
  J_TITLE NVARCHAR2(20) NOT NULL, --문서제목
  J_ACCOUNT NVARCHAR2(20) NOT NULL, --계정과목
  J_GROUP NVARCHAR2(20) NOT NULL, --비용구분
  J_DEVIT NVARCHAR2(20) NOT NULL, --차변금액
  J_CREDIT NVARCHAR2(20) NOT NULL, --대변금액
  J_COMPANY NVARCHAR2(20) NOT NULL, --관계회사
  J_CENTRE NVARCHAR2(20) NOT NULL, --활동센터
  J_SECTION NVARCHAR2(20) NOT NULL, --귀속부서
  J_SUMUP NCLOB NOT NULL, --적요
  J_REASON NCLOB, --반려사유
  J_GRADE NCHAR(1) DEFAULT 0 NOT NULL, --결재상태
  J_NONE NVARCHAR2(20) NOT NULL,
  J_NTWO NVARCHAR2(20) NOT NULL,
  J_NTHR NVARCHAR2(20) NOT NULL, --반려/결재이름 123
  CONSTRAINT AC_JNOB_PK PRIMARY KEY (J_CCODE, J_DOCUNUM),
  CONSTRAINT AJ_JNOB_FK FOREIGN KEY (J_DOCUNUM, J_CCODE) REFERENCES APPROVALDOCU (AP_DOCUNUM, AP_CCODE)
);

--매출/매입전표, 품목상세 (가데이터)
CREATE TABLE AC_SALESTATEMENT(
  S_NUM NVARCHAR2(10) NOT NULL, --전표번호
  S_CCODE NVARCHAR2(20) NOT NULL,
  S_CLCODE NVARCHAR2(20) NOT NULL, --거래처회사코드
  S_KIND NVARCHAR2(20) NOT NULL, --종류
  S_TOTAL NVARCHAR2(20) NOT NULL, --합계
  S_COMNUM NVARCHAR2(20) NOT NULL,
  S_DATE DATE DEFAULT SYSDATE NOT NULL,
  S_EMPLOYEE NVARCHAR2(20) NOT NULL, --담당자
  S_MEMO NVARCHAR2(40) NOT NULL, --적요
  CONSTRAINT AC_SALESTATEMENT_PK PRIMARY KEY (S_NUM, S_CCODE),
  CONSTRAINT AC_SALESTATEMENT_FK FOREIGN KEY (S_CLCODE, S_CCODE) REFERENCES AC_COMPANYLIST (CL_CODE, CL_CCODE)
);
CREATE TABLE AC_SALESTATEMENTLIST( --상세
  SL_NUM NVARCHAR2(10) NOT NULL, --전표번호
  SL_CCODE NVARCHAR2(20) NOT NULL,
  SL_CNT NVARCHAR2(20) NOT NULL, --수량
  SL_PKIND NVARCHAR2(20) NOT NULL, --품목
  SL_TAX NVARCHAR2(20) NOT NULL, --부가세액
  SL_PRICE NVARCHAR2(20) NOT NULL, --단가
  SL_PRICE2 NVARCHAR2(20) NOT NULL --공급가액
);

--매출/매입전표 본데이터
CREATE TABLE AC_REALSALESTATEMENT(
  RS_NUM NVARCHAR2(10) NOT NULL, --전표번호
  RS_CCODE NVARCHAR2(20) NOT NULL,
  RS_DOCUNUM NVARCHAR2(10) NOT NULL, --문서번호
  RS_CLCODE NVARCHAR2(20) NOT NULL, --거래처
  RS_APPROVER1 NVARCHAR2(20) NOT NULL,
  RS_APPROVER2 NVARCHAR2(20) NOT NULL,
  RS_APPROVER3 NVARCHAR2(20) NOT NULL, --결재자 123
  RS_REFER1 NVARCHAR2(20),
  RS_REFER2 NVARCHAR2(20),
  RS_REFER3 NVARCHAR2(20), --참조자 123
  RS_TOTAL NVARCHAR2(20) NOT NULL, --합계
  RS_REASON NCLOB NOT NULL, --이유
  RS_DATE DATE DEFAULT SYSDATE NOT NULL,
  RS_KIND NVARCHAR2(20) NOT NULL, --종류
  CONSTRAINT AC_REALSALESTATEMENT_PK PRIMARY KEY (RS_NUM, RS_CCODE, RS_DOCUNUM),
  CONSTRAINT AC_REALSALESTATEMENT_FK1 FOREIGN KEY (RS_DOCUNUM, RS_CCODE) REFERENCES APPROVALDOCU (AP_DOCUNUM, AP_CCODE),
  CONSTRAINT AC_REALSALESTATEMENT_FK2 FOREIGN KEY (RS_CLCODE, RS_CCODE) REFERENCES AC_COMPANYLIST (CL_CODE, CL_CCODE)
);
CREATE TABLE AC_REALSALESTATEMENTLIST( --상세
  RSL_NUM NVARCHAR2(10) NOT NULL,
  RSL_CCODE NVARCHAR2(20) NOT NULL,
  RSL_DOCUNUM NVARCHAR2(10) NOT NULL,
  RSL_TAX NVARCHAR2(20) NOT NULL,
  RSL_PRICE NVARCHAR2(20) NOT NULL,
  RSL_PRICE2 NVARCHAR2(20) NOT NULL,
  RSL_CNT NVARCHAR2(10) NOT NULL,
  RSL_PKIND NVARCHAR2(20) NOT NULL,
  CONSTRAINT AC_REALSALESTATEMENTLIST_FK FOREIGN KEY (RSL_NUM, RSL_CCODE, RSL_DOCUNUM) REFERENCES AC_REALSALESTATEMENT (RS_NUM, RS_CCODE, RS_DOCUNUM)
);



---------------------------
---------CREATE SEQ--------
---------------------------

-->>홈페이지 SEQ
CREATE SEQUENCE BR_NUM_SEQ; --게시글
CREATE SEQUENCE COMPANY_SEQ; --회사코드

-->>인사 SEQ
CREATE SEQUENCE HR_CARD_SEQ;
CREATE SEQUENCE HR_CAREER_SEQ;
CREATE SEQUENCE HR_CERTIFICATION_SEQ;
CREATE SEQUENCE HR_ACADEMIC_SEQ;
--휴가
CREATE SEQUENCE HR_APPLYHOLIDAY_SEQ;

-->>영업 SEQ
CREATE SEQUENCE B_ORDER_SEQ; --수주
CREATE SEQUENCE B_ACTIVITES_SEQ; --영업
CREATE SEQUENCE B_SHIPMENT_SEQ; --출하

-->>재고 SEQ
CREATE SEQUENCE S_IEPORT_SEQ; --입/출고
CREATE SEQUENCE S_ITEMCODE_SEQ; --품목코드

-->>구매 SEQ
CREATE SEQUENCE O_PURCHASEPROGRAM_SEQ; --구매
CREATE SEQUENCE O_ORDER_SEQ; --발주
CREATE SEQUENCE O_RETURNPROGRAM_SEQ; --반품

-->>회계 SEQ
CREATE SEQUENCE AC_JNOB_SEQ; --분개전표코드
CREATE SEQUENCE AC_JNOBDOCU_SEQ; --분개전표문서
CREATE SEQUENCE AC_REALSALESTATEMENT_SEQ; --매출/매입전표코드
CREATE SEQUENCE AC_REALSALESTATEMENTDOCU_SEQ; --매출/매입전표문서
