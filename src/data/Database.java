package data;

import java.sql.Date;
import java.util.ArrayList;

import util.DateUtil;
import vo.AreaVO;
import vo.BookVO;
import vo.BookingVO;
import vo.NoticeVO;
import vo.PostVO;
import vo.RentalVO;
import vo.RequestVO;
import vo.ReviewVO;
import vo.UserVO;

public class Database {

	
	private static Database instance;
	private Database(){}
		
	public static Database getInstance(){
			if(instance == null){
				instance = new Database();
			}
			return instance;
	}
	
	//유저 개인정보 목록 (회원가입 정보)
	public ArrayList<UserVO> tb_user = new ArrayList<UserVO>();
		{
			UserVO user = new UserVO();
			user.setUserID("admin");
			user.setPassword("admin");
			user.setUserName("관리자");
			user.setBirthDate("1970년 1월 1일");
			user.setEmail("asdf@asdf.com");
			user.setAddress("asdf@asdf.com");
			user.setTel("010-000-0000");
			tb_user.add(user);
			
			user = new UserVO();
			user.setUserID("abc123");
			user.setPassword("abc123");
			user.setUserName("abc123");
			user.setBirthDate("abc123");
			user.setEmail("abc123");
			user.setAddress("abc123");
			user.setTel("abc123");
			tb_user.add(user);
		}
	
	//책 분야 목록
	public ArrayList<AreaVO> tb_bookArea = new ArrayList<AreaVO>();
		{
			AreaVO bookArea = new AreaVO();
			bookArea.setAreaNumber("A");
			bookArea.setAreaName("문학");
			
			tb_bookArea.add(bookArea);
	
			bookArea = new AreaVO();
			bookArea.setAreaNumber("B");
			bookArea.setAreaName("철학");
			
			tb_bookArea.add(bookArea);
		
			bookArea = new AreaVO();
			bookArea.setAreaNumber("C");
			bookArea.setAreaName("종교");
			
			tb_bookArea.add(bookArea);
		
			bookArea = new AreaVO();
			bookArea.setAreaNumber("D");
			bookArea.setAreaName("사회과학");
			
			tb_bookArea.add(bookArea);
		
			bookArea = new AreaVO();
			bookArea.setAreaNumber("E");
			bookArea.setAreaName("자연과학");
			
			tb_bookArea.add(bookArea);
		}
	
		
	
	//도서 목록
	public ArrayList<BookVO> tb_book = new ArrayList<BookVO>(); 
		{
			
			BookVO book = new BookVO();
			book.setBookNumber("A001");
			book.setAreaNumber("A");
			book.setBookName("사씨남정기");
			book.setWriter("주재우");
			book.setBookInfo("사씨남정기는 총명한 관리 유연수가 현명한 부인 사정옥을 만나 행복하게 지내던 중 가문의 대를 잇고자 들인 첩 교채란의 사악한 음모로 가문이 와해되는 위기를 겪게 되는 가문 소설입니다.");
			book.setAccession("2019년 10월 14일");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A002");
			book.setAreaNumber("A");
			book.setBookName("엄마는 알지");
			book.setWriter("노길자");
			book.setBookInfo("갓 태어난 아기에서부터 만 2세까지의 영아기 유아들을 위한 창작 유아 낭송 시집이다. 엄마가 아기에게 낭송해줄 수 있는 유아들을 위한 31편의 시를 화사한 화풍의 삽화와 함께 시집으로 엮었다.");
			book.setAccession("2019년 9월 14일");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A003");
			book.setAreaNumber("A");
			book.setBookName("역린");
			book.setWriter("최성현");
			book.setBookInfo("18세기 영.정조 시대를 배경으로 궁중의 암투와 모략을 정치 스릴러로 쓴 소설");
			book.setAccession("2019년 10월 15일");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A004");
			book.setAreaNumber("A");
			book.setBookName("미치도록 가렵다");
			book.setWriter("김선영");
			book.setBookInfo("김선영 작가 특유의 탄탄한 이야기 구조와 섬세한 문장으로 지금을 살고 있는 청소년과 어른, 모두가 한결같이 앓고 있는 가려움, 불안에 대해 조명한다.");
			book.setAccession("2019년 10월 16일");
			book.setInventory(3);
			tb_book.add(book);
			
		
			book = new BookVO();
			book.setBookNumber("A005");
			book.setAreaNumber("A");
			book.setBookName("사슴 사냥꾼");
			book.setWriter("이해경");
			book.setBookInfo("장편소설에 적합한 지구력과 돌파력, 안정적인 문장력 등을 두루 인정받으며 제8회 문학동네소설상을 수상한 이해경의 장편소설");
			book.setAccession("2019년 10월 7일");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A006");
			book.setAreaNumber("A");
			book.setBookName("제국의 역습");
			book.setWriter("허수정");
			book.setAccession("2019년 10월 14일");
			book.setBookInfo("만약 도요토미 히데요시가 암살당했고, 그 배후가 조선의 15대 왕 광해군이었다면. 이 책은 임진왜란의 종결과 도요토미 히데요시의 죽음에 얽힌 불가사의한 비밀을 파헤치는 팩션이다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A007");
			book.setAreaNumber("A");
			book.setBookName("19 씩씩한게 아픈");
			book.setWriter("감성현");
			book.setAccession("2019년 10월 13일");
			book.setBookInfo("어린 시절부터 사귀어 온 루다와 다해. 일찌감치 자기 목표를 정하고 로봇공학자가 되기 위해 학교를 그만 두고 독일로 유학을 간 다해와는 달리 루다는 열망도 목표도 없는 세월을 보내며 점점 자신감을 잃어만 가는데..");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A008");
			book.setAreaNumber("A");
			book.setBookName("백만장자 키워드");
			book.setWriter("마크피셔");
			book.setAccession("2019년 10월 8일");
			book.setBookInfo("이 백지 소개장을 들고가서 만난 밀리어네어 씨는 돈 한푼 없는 나에게 1만달러짜리 수표를 반 강제적으로 쓰게하고 부자가 되는 비법이 들어있다는 봉투를 건넨다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A009");
			book.setAreaNumber("A");
			book.setBookName("청소년 토지");
			book.setWriter("박경리");
			book.setAccession("2019년 10월 7일");
			book.setBookInfo("일제 강점기, 그 핍박과 억압의 시기를 청소년에게 알리고자 하는 작가의 마음을 담아낸 도서.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A010");
			book.setAreaNumber("A");
			book.setBookName("공부 없는 나라");
			book.setWriter("조한서");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("생각쑥쑥문고 6권. 아이들이라면 한번쯤 꿈꿔본 나라, 공부 없는 나라. 이 흥미진진한 상상력을 통해 진짜 공부의 이유를 찾아가는 영훈을 만나게 된다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A011");
			book.setAreaNumber("A");
			book.setBookName("분홍문의 기적");
			book.setWriter("강정연");
			book.setAccession("2019년 10월 3일");
			book.setBookInfo("교통사고로 엄마를 잃고 난 후 엉망진창으로 살던 아빠 박진정 씨와 아들 박향기가 날개 달린 엄지 공주 같은 작은 모습으로 돌아온 엄마와 72시간을 함께하는, 마음 찌릿하고 간절한 판타지가 담긴 동화");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A012");
			book.setAreaNumber("A");
			book.setBookName("열세번째 아이");
			book.setWriter("이은용");
			book.setAccession("2019년 10월 13일");
			book.setBookInfo("정을 느낄 줄 아는 감정 로봇이 개발되어 판매되는 2075년을 배경으로,진짜 행복이 무엇인지 진짜 나는 누구인지 존엄성이란 무엇인지 그 답을 찾아가는 여정");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A013");
			book.setAreaNumber("A");
			book.setBookName("심청전");
			book.setWriter("김예선");
			book.setAccession("2019년 10월 12일");
			book.setBookInfo("우리 나라의 수많은 고전 중 끊임 없는 생명력으로 오늘날까지 널리 사랑받는 작품 중 하나인 심청전을 새로운 시각에서 바라보고 재해석한 작품");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A014");
			book.setAreaNumber("A");
			book.setBookName("검은 모래    ");
			book.setWriter("구소은");
			book.setAccession("2019년 10월 12일");
			book.setBookInfo("제주 우도의 검은 모래 해안에서부터 일본의 화산섬 미야케지마까지 4대에 걸쳐 이어지는 한 잠녀 가족의 삶의 역정과 드라마를 감동적으로 그려낸 작품이다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A015");
			book.setAreaNumber("A");
			book.setBookName("그녀가 죽길 바라다");
			book.setWriter("정수현");
			book.setAccession("2019년 10월 12일");
			book.setBookInfo("젊은 여성 독자의 큰 공감대를 형성했던 정수현 작가가 2011년 겨울, 예상을 뒤엎는 장편 로맨틱 미스터리 소설로 새로운 모습을 선보인다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A016");
			book.setAreaNumber("A");
			book.setBookName("굿바이 미스터 하필");
			book.setWriter("김진경");
			book.setAccession("2019년 10월 25일");
			book.setBookInfo("누구나 애써 기억에서 지워버리고 싶은 아픈 기억을 억지로라도 기억해내고 말하는 과정을 통해 한 인간의 성장을 이야기한다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A017");
			book.setAreaNumber("A");
			book.setBookName("달의시1      ");
			book.setWriter("이선미");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("인간과 종족을 넘어선 두 사람의 뜨거운 사랑을 그렸다");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A018");
			book.setAreaNumber("A");
			book.setBookName("반야 1");
			book.setWriter("송은일");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("조선 시대 하층 계급으로 살아가는 무당 반야와, 모든 사람이 평등한 이상 세계의 시현을 꿈꾸는 조직인 사신계가 소설의 중요한 두 축이다.");
			book.setInventory(3);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("A019");
			book.setAreaNumber("A");
			book.setBookName("콩 심기");
			book.setWriter("신보름");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("집안일과 농사일로 한평생을 살았지만, 서울에 올라와서도 농사짓는 옥님 할머니할머니가 손녀에게 전하는 따뜻한 삶의 지혜");
			book.setInventory(3);
			tb_book.add(book);

			book = new BookVO();
			book.setBookNumber("A020");
			book.setAreaNumber("A");
			book.setBookName("캉탕");
			book.setWriter("이승우");
			book.setAccession("2019년 10월 24일");
			book.setBookInfo("등단 이후 38년 동안 한국 문학에서 대체 불가능한 자기만의 자리를 확고히 하고 있는 이승우의 세계관이 집약된 작품이다.");
			book.setInventory(3);
			tb_book.add(book);
		
			//B책장시작//////////////////////////////////////////////////////////	
			book = new BookVO();
			book.setBookNumber("B001");
			book.setAreaNumber("B");
			book.setBookName("방법을 철학한다");
			book.setWriter("이광래");
			book.setBookInfo("철학한다는 것이 무엇인가에 대하여 묻고 답하는 담론서이다.");
			book.setAccession("2019년 10월 1일");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B002");
			book.setAreaNumber("B");
			book.setBookName("대화의 철학");
			book.setWriter("이규호");
			book.setAccession("2019년 10월 8일");
			book.setBookInfo("새로운 세기를 맞이하는 이땅의 지성인과 지도자들에게 제시하는 철학의 방법론");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B003");
			book.setAreaNumber("B");
			book.setBookName("그로테스크의 몸");
			book.setWriter("몸문화연구소");
			book.setAccession("2019년 10월 8일");
			book.setBookInfo("아름다움과 추, 정상과 비정상 사이에는 존재론적인 연속성과 순환이 있다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B004");
			book.setAreaNumber("B");
			book.setBookName("멜랑콜리 미학");
			book.setWriter("김동규");
			book.setAccession("2019년 10월 8일");
			book.setBookInfo("인간의 근원적인 감정 사랑, 질투, 희생, 이별, 죽음 등에 대하여 이야기한다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B005");
			book.setAreaNumber("B");
			book.setBookName("미학");
			book.setWriter("알렉산더 ");
			book.setAccession("2019년 10월 24일");
			book.setBookInfo("미학 을 철학의 하위 분과가 아닌 독립된 학문으로 정초하였다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B006");
			book.setAreaNumber("B");
			book.setBookName("우리 모두 왕");
			book.setWriter("하인츠");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("존재에 관한 짧지만 큰 울림을 주는 스무 가지 이야기를 담은 책입니다. ");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B007");
			book.setAreaNumber("B");
			book.setBookName("미학 수업    ");
			book.setWriter("문광훈");
			book.setAccession("2019년 9월 1일");
			book.setBookInfo("우리가 살아가는 현실에서 왜 예술이 중요하며 그 예술을 통해 개인의 삶은 어떻게 변화될 수 있는가 에 대해 말하고 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B008");
			book.setAreaNumber("B");
			book.setBookName("심미안 수업");
			book.setWriter("윤광준");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("이토록 삶이 거친 것은 뭐가 아름다운지 내가 무엇을 좋아하는지 모르기 때문이다 우리에게 심미안 수업이 필요한 이유다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B009");
			book.setAreaNumber("B");
			book.setBookName("아름다움의 구원");
			book.setWriter("한병철");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("자본주의 사회에서 추구되는 아름다움은 모든 부정성과 낯섦을 제거하고 긍정성과 자기 동일성만이 부유하는 매끄러움의 미에 지나지 않게 됐다고 말한다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B010");
			book.setAreaNumber("B");
			book.setBookName("전체성과 무한");
			book.setWriter("에바뉘엘");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("타자 전체성 무한 초월 책임 향유 맞아들임 얼굴 근접성 등이 망라되어 등장하며 또 체계적으로 엮여서 다루어진다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B011");
			book.setAreaNumber("B");
			book.setBookName("아름다운 사람");
			book.setWriter("아시아");
			book.setAccession("2019년 10월 15일");
			book.setBookInfo("사회적 영성을 찾는 사람이 되는 길은 새로운 삶의 방식에 대한 고민의 과정이다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B012");
			book.setAreaNumber("B");
			book.setBookName("어떤 밤");
			book.setWriter("트린 주안");
			book.setAccession("2019년 9월 25일");
			book.setBookInfo("분야 세계 최고의 석학 트린 주안 투안이 들려주는 밤과 인간 존재의 근원에 관한 이야기");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B013");
			book.setAreaNumber("B");
			book.setBookName("시간의 향기");
			book.setWriter("한병철");
			book.setAccession("2019년 9월 25일");
			book.setBookInfo("대사회의 모든 시간이 노동의 인질이 되었음을 포착한다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B014");
			book.setAreaNumber("B");
			book.setBookName("글로벌 생명학");
			book.setWriter("이기상");
			book.setAccession("2019년 9월 25일");
			book.setBookInfo("21세기 지구 살림살이를 위해 새롭게 대두된 생명학의 정립을 위한 시도와 해법을 담은 역저");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B015");
			book.setAreaNumber("B");
			book.setBookName("타임");
			book.setWriter("카틴카");
			book.setAccession("2019년 9월 26일");
			book.setBookInfo("시간은 인간에게 어떤 의미로 다가오는가각계각층의 전문가들이 펼치는 담론의 향연 속에 시간의 의미들이 입체적으로 드러난다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B016");
			book.setAreaNumber("B");
			book.setBookName("시간 추적자들");
			book.setWriter("하랄트");
			book.setAccession("2019년 9월 25일");
			book.setBookInfo("이 책은 우리가 일상적으로 접하는 그러나 실체를 제대로 알지 못하는 시간의 개념에 대해서 역사적이고 체계적으로 접근하고 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B017");
			book.setAreaNumber("B");
			book.setBookName("시간이란 무엇인가?");
			book.setWriter("클라우스");
			book.setAccession("2019년 9월 27일");
			book.setBookInfo("이 책은 우리가 일상적으로 접하는 그러나 실체를 제대로 알지 못하는 시간의 개념에 대해서 역사적이고 체계적으로 접근하고 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B018");
			book.setAreaNumber("B");
			book.setBookName("대장장이와 연금술사");
			book.setWriter("미르치아");
			book.setAccession("2019년 9월 25일");
			book.setBookInfo("세계 각지의 원시사회 대장장이 업과 연금술 특유의 신화, 의례, 상징들을 심도있게 고찰하고 있는 책");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B019");
			book.setAreaNumber("B");
			book.setBookName("우주의 수수께끼");
			book.setWriter("게르하르트");
			book.setAccession("2019년 9월 25일");
			book.setBookInfo("문학과 종교학을 전공한 저자가 그 과정에서 끊임없이 우주와 생명의 창조에 있어서 신의 존재와 역할에 대해 묻고 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("B020");
			book.setAreaNumber("B");
			book.setBookName("꼭두각시의 영혼");
			book.setWriter("존 그레이");
			book.setAccession("2019년 10월 25일");
			book.setBookInfo("인간이 다른 동물보다 우월하다는 착각이 지구를 파괴하고 인류를 망치고 있다고 소리 높여 주장했던 존 그레이는 이번 책을 통해 인간은 자유롭다는 생각이야말로 엄청난 착각이고 망상이라 역설한다");
			book.setInventory(1);
			tb_book.add(book);
			
			//C책장시작//////////////////////////////////////////////
			book = new BookVO();
			book.setBookNumber("C001");
			book.setAreaNumber("C");
			book.setBookName("한국의 신선");
			book.setWriter("임채우");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("단군부터 현대까지 한국의 신선이능화 조선도교사 이래 믿고 읽을 만한 조선선도사에 대한 연구서가 출간되었다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C002");
			book.setAreaNumber("C");
			book.setBookName("철든 가족    ");
			book.setWriter("만월");
			book.setAccession("2019년 10월 1일");
			book.setBookInfo("가족이라는 울타리 안에서나와 가족의 행복한 동행이 시작된다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C003");
			book.setAreaNumber("C");
			book.setBookName("황금꽃의 비밀");
			book.setWriter("구스타프 융");
			book.setAccession("2019년 10월 11일");
			book.setBookInfo("접근 자체도 쉽지 않고 접근하더라도 텍스트의 진의를 해석해내기 어려운 도교 경전을 서구의 두 지성이 깊고 정확한 이해를 통해 서양에 처음으로 소개한 것이다.");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C004");
			book.setAreaNumber("C");
			book.setBookName("도를 닦는다는 것");
			book.setWriter("곽종인");
			book.setAccession("2019년 9월 11일");
			book.setBookInfo("종파와 종교를 막론하고 모든 구도자, 수행자들의 관심을 받았던 한몸에 받았던 곽종인 대사가 집필한 책.");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C005");
			book.setAreaNumber("C");
			book.setBookName("도교");
			book.setWriter("앙리");
			book.setAccession("2019년 10월 11일");
			book.setBookInfo("역사발전과 중국 종교, 고대 중국인과 근대 따이족의 사회와 종교,육조시대의 종교신앙에서의 도교 등 8개 장으로 설명했다.");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C006");
			book.setAreaNumber("C");
			book.setBookName("무교");
			book.setWriter("최준식");
			book.setAccession("2019년 10월 11일");
			book.setBookInfo("한국인의 정신세계의 근저에 기층문화로서 자리 잡고 있는 무교가 우리 역사에서 어떻게 미신이자 무속으로 왜곡되고 비하되어 왔는지 살펴보는 책이다.");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C007");
			book.setAreaNumber("C");
			book.setBookName("악마 백과사전");
			book.setWriter("프레드");
			book.setAccession("2019년 10월 22일");
			book.setBookInfo("세상의 모든 악마들을 한자리에 불러모았다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C008");
			book.setAreaNumber("C");
			book.setBookName("돈 후앙의 가르침");
			book.setWriter("카를로스");
			book.setAccession("2019년 10월 11일");
			book.setBookInfo("전 세계 800만 부 판매물질문명 정반대편의 지식체계를 낱낱이 밝힘으로써구도자 철학자 예술가들에게 무한한 영감을 선물해준 책");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C009");
			book.setAreaNumber("C");
			book.setBookName("윤회의 본질");
			book.setWriter("베이치");
			book.setAccession("2019년 10월 2일");
			book.setBookInfo("이 책 안에 소개된 사례들은 그중 극히 일부에 불과하다전생의 기억은 어떤 계기로 떠오르는가현대의 연구가들이 조사한 전생의 기억들은 두 유형으로 분류된다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C010");
			book.setAreaNumber("C");
			book.setBookName("여신들");
			book.setWriter("조지프");
			book.setAccession("2019년 10월 17일");
			book.setBookInfo("이 책은 남성 신화에 덮이고 통합된 여성 신화의 맨 얼굴을 찾아가는 캠벨의 여정이다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C011");
			book.setAreaNumber("C");
			book.setBookName("죽음과 종교");
			book.setWriter("장경철");
			book.setAccession("2019년 9월 21일");
			book.setBookInfo("이 책은 언제 맞이하게 될지 모르는 죽음에 대해 미리 생각하고 죽음을 통해 삶을 새롭게 조명해 보도록 도와준다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C012");
			book.setAreaNumber("C");
			book.setBookName("초인수업");
			book.setWriter("카를로스");
			book.setAccession("2019년 9월 21일");
			book.setBookInfo("멕시코 야키족 주술사 돈 후앙을 만나 약초들에 관한 전통지식을 수집하려 했던 UCLA의 인류학도 카스타네다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C013");
			book.setAreaNumber("C");
			book.setBookName("애니미즘이라는 희망");
			book.setWriter("야마오");
			book.setAccession("2019년 8월 21일");
			book.setBookInfo("일본의 시인이며 농부였던 야마오 산세이가 애니미즘을 주제로 한 5일간의 강연록이다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C014");
			book.setAreaNumber("C");
			book.setBookName("천국의 세계");
			book.setWriter("구사노");
			book.setAccession("2019년 9월 21일");
			book.setBookInfo("신화 전설 경전을 통해 인류의 역사 속에 존재했던 다양한 사후세계를 살펴본다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C015");
			book.setAreaNumber("C");
			book.setBookName("세계의 천사와 악마");
			book.setWriter("이경윤");
			book.setAccession("2019년 10월 14일");
			book.setBookInfo("막연한 상상 속에 존재하는 천사와 악마를 만나게 해주는 여행서다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C016");
			book.setAreaNumber("C");
			book.setBookName("악마, 천년의 역사");
			book.setWriter("로베르");
			book.setAccession("2019년 10월 14일");
			book.setBookInfo("서양역사에 나타나는 악마의 변화무쌍한 개념과 의미를 시간과 공간 여행을 통해 보여준다.");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C017");
			book.setAreaNumber("C");
			book.setBookName("나를 변화시킨 깃털");
			book.setWriter("메릴");
			book.setAccession("2019년 10월 14일");
			book.setBookInfo("신비한 힘의 상징으로 여겨져 오는 깃털에 얽힌 다양한 사람들의 경험담을 수록했다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C018");
			book.setAreaNumber("C");
			book.setBookName("저승");
			book.setWriter("사나소");
			book.setAccession("2019년 10월 12일");
			book.setBookInfo("인간 생사에 관한 아주 유별난 보고서 이 책은 저자가 죽음과 영혼저승의 문제들에 흥미를 가지고 모은 자료들을 엮은 것이다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C019");
			book.setAreaNumber("C");
			book.setBookName("야생의 사고");
			book.setWriter("스트로스");
			book.setAccession("2019년 10월 14일");
			book.setBookInfo("미개인이라 불리는 사람들의 사고의 깊이와 내재적 논리구조를 밝히고, 서구인이 갖는 2차적 본성인 과학, 철학의 방법론적 선입견을 벗겨낸다");
			book.setInventory(1);
			tb_book.add(book);
			
			
			book = new BookVO();
			book.setBookNumber("C020");
			book.setAreaNumber("C");
			book.setBookName("한국의 샤머니즘");
			book.setWriter("조흥윤");
			book.setAccession("2019년 10월 21일");
			book.setBookInfo("새남굿의 소개를 통해 한국 샤머니즘의 실체를 보여주고 있다.");
			book.setInventory(1);
			tb_book.add(book);
			
			//D책장시작/////////////////////////////////////////////////
			book = new BookVO();
			book.setBookNumber("D001");
			book.setAreaNumber("D");
			book.setBookName("21세기 자본");
			book.setWriter("피케티");
			book.setAccession("2019년 9월 14일");
			book.setBookInfo("지난해 8월에 프랑스, 올해 4월에 미국에서 번역 출간된 이후 경제계는 물론 세계 지성인의 주목을 한 몸에 받아온 역작이다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D002");
			book.setAreaNumber("D");
			book.setBookName("나는 미련없이 사표");
			book.setWriter("모리 겐");
			book.setAccession("2019년 9월 15일");
			book.setBookInfo("회사라는 안정된 공간을 벗어나 자신이 좋아하는 일로 살아가는 13명의 이열치열 자립 스토리를 담았다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D003");
			book.setAreaNumber("D");
			book.setBookName("빈곤의 덫 걷어차기");
			book.setWriter("제이콥");
			book.setAccession("2019년 10월 14일");
			book.setBookInfo("딘 칼런 예일대 교수가 내놓은 전 세계적인 부의 불균형과 빈곤문제에 대한 행동경제학적 해법이 담긴 책.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D004");
			book.setAreaNumber("D");
			book.setBookName("굿바이 쇼핑");
			book.setWriter("주디스");
			book.setAccession("2019년 10월 22일");
			book.setBookInfo("1년 동안 쇼핑 안 하기 프로젝트를 계획하고 실천한 기록을 담은 책.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D005");
			book.setAreaNumber("D");
			book.setBookName("4천원 인생");
			book.setWriter("안수찬");
			book.setAccession("2019년 10월 9일");
			book.setBookInfo("한 시사주간지 사회팀 기자들이 한 달간 빈곤 노동의 현장에 위장취업하여 경험한 일터와 삶에 대한 생생한 이야기들.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D006");
			book.setAreaNumber("D");
			book.setBookName("4차 산업혁명");
			book.setWriter("남충현");
			book.setAccession("2019년 7월 9일");
			book.setBookInfo("4차 산업혁명에 대한 핵심 쟁점들을 총정리한 책이다 이 책은 4차 산업혁명에 대한 굵직한 12가지 질문들을 던진다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D007");
			book.setAreaNumber("D");
			book.setBookName("핵발전소 노동자");
			book.setWriter("테라오");
			book.setAccession("2019년 9월 9일");
			book.setBookInfo("반핵을 노래하는 가수가 핵발전소에서 일한 적이 있는 여섯 명의 핵발전소 노동자를 인터뷰하여 그 실상을 기록하다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D008");
			book.setAreaNumber("D");
			book.setBookName("돈의 감각    ");
			book.setWriter("이명로");
			book.setAccession("2019년 8월 10일");
			book.setBookInfo("돈 센스는 타고나는 것이 아니라 기르는 것이다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D009");
			book.setAreaNumber("D");
			book.setBookName("일자리의 미래");
			book.setWriter("엘렌 러펠");
			book.setAccession("2019년 10월 10일");
			book.setBookInfo("엘렌 러펠 셸 교수는 로봇과 인공지능AI의 상용화로 촉발되고 있는 일자리의 자동화가 특히 중산층의 일자리를 빼앗고 있다고 진단한다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D010");
			book.setAreaNumber("D");
			book.setBookName("가장 보통의 드라마");
			book.setWriter("이한솔");
			book.setAccession("2019년 10월 20일");
			book.setBookInfo("2016년 노량진 공시생들의 애환을 그려내며 장안의 화제가 됐던 tvN 드라마 마지막 화가 방영된 다음 날 조연출이었던 이한빛PD가 스스로 목숨을 끊는 일이 벌어졌다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D011");
			book.setAreaNumber("D");
			book.setBookName("제도의 힘    ");
			book.setWriter("김승욱");
			book.setAccession("2019년 9월 29일");
			book.setBookInfo("제도의 힘은 경제성장을 이루는 데 가장 중요한 제도가 시장경제라는 것을 밝히고 제도주의 관점에서 선진국이 어떻게 부국이 되었는지 풀었다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D012");
			book.setAreaNumber("D");
			book.setBookName("스타벅스화");
			book.setWriter("유승호");
			book.setBookInfo("스타벅스는 도시인이 추구하는 새로운 욕망과 가치를 업고 한국의 거리를 지배하고 있는데 도서출판 따비의 신간 스타벅스화 ");
			book.setInventory(1);
			tb_book.add(book);
											
			book = new BookVO();
			book.setBookNumber("D013");
			book.setAreaNumber("D");
			book.setBookName("청년의사 성장기");
			book.setWriter("허기영");
			book.setBookInfo("청년 의사의 리얼 의사 생존 보고서 이 책은 청년 의사인 저자가 의사가 만들어지는 과정이 어떠한지를 솔직하게 전달하기 위해 쓴 것이다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D014");
			book.setAreaNumber("D");
			book.setBookName("웹소설 작가");
			book.setWriter("노경찬");
			book.setBookInfo("청소년들의 진로와 직업 탐색을 위한 잡프러포즈 스물한 번째 시리즈 재미있는 글을 추구하는 웹소설작가");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D015");
			book.setAreaNumber("D");
			book.setBookName("동시통역사");
			book.setWriter("이윤희");
			book.setBookInfo("스스로 모든 걸 해내야 하기 때문에 때론 힘들기도 하지만 그만큼 생동감 있게 삶을 꾸려갈 수 있는 이 일 동시통역사를 프러포즈한다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D016");
			book.setAreaNumber("D");
			book.setBookName("24시간이 모자라!");
			book.setWriter("한정영");
			book.setAccession("2019년 10월 13일");
			book.setBookInfo("진로 결정과 직업 선택에 꼭 필요한 직업 이해와 적성 탐구 이 두 가지를 재미있는 이야기로 깨닫게 하는 북멘토 직업가치동화 세 번째 수의사 편이다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D017");
			book.setAreaNumber("D");
			book.setBookName("내 직업 내가 만든다");
			book.setWriter("박시현");
			book.setAccession("2019년 9월 22일");
			book.setBookInfo("내가 좋아하고 잘하는 것으로 내 일을 만든다 경력 단절 여성들을 위한 첫 창직 안내서");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D018");
			book.setAreaNumber("D");
			book.setBookName("위장환경주의");
			book.setWriter("카트린");
			book.setAccession("2019년 9월 30일");
			book.setBookInfo("기온 상승을 억제하기 위해 전 지구적으로 다각적인 노력을 펼치고 있으나 번번이 실패했다 그렇다면 그 실패의 원인은 무엇일까");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D019");
			book.setAreaNumber("D");
			book.setBookName("예능피디");
			book.setWriter("신정수");
			book.setAccession("2019년 10월 15일");
			book.setBookInfo("예능 PD 전성기 중국 예능 진출 한국 예능의 세계화 전망까지 신정수 PD만의 솔직 담백한 토크가 여러분을 기다립니다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("D020");
			book.setAreaNumber("D");
			book.setBookName("땅과 집 이야기");
			book.setWriter("손낙구");
			book.setAccession("2019년 10월 26일");
			book.setBookInfo("10대의 눈높이에서 살펴본 대한민국의 땅과 집 이야기를 담고 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			//E책장시작/////////////////////////////////////////////////
			book = new BookVO();
			book.setBookNumber("E001");
			book.setAreaNumber("E");
			book.setBookName("우리풀백과사전");
			book.setWriter("이유미");
			book.setAccession("2019년 6월 29일");
			book.setBookInfo("식물 이해의 첫걸음이 될 식물 계통에 대한 개념, 식물의 계통수를 함께 담았다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E002");
			book.setAreaNumber("E");
			book.setBookName("슈베르트와 나무");
			book.setWriter("고규홍");
			book.setAccession("2019년 6월 7일");
			book.setBookInfo("나무 인문학자 고규홍이 시각장애인 피아니스트 김예지와 함께 시도하는 나무 바라보기.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E003");
			book.setAreaNumber("E");
			book.setBookName("궁궐의 우리 나무");
			book.setWriter("박상진");
			book.setAccession("2019년 8월 13일");
			book.setBookInfo("이 책은 조선 시대 한국의 궁궐 경복궁, 창덕궁, 창경궁, 덕수궁… 에 심어진 우리 수목 98종을 하나씩 살펴본다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E004");
			book.setAreaNumber("E");
			book.setBookName("나무가 민중이다");
			book.setWriter("고주환");
			book.setAccession("2019년 9월 2일");
			book.setBookInfo("우리의 농경문화 속에서 민초의 삶에 가장 가까이 있었던 풀과 나무를 그 민초의 생활 속 눈높이로 바라본 나무 이야기.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E005");
			book.setAreaNumber("E");
			book.setBookName("나무와 숲의 연대기");
			book.setWriter("데이비드");
			book.setAccession("2019년 8월 8일");
			book.setBookInfo("화가 로버트 베이트먼의 정겨운 세밀화가 담겨 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E006");
			book.setAreaNumber("E");
			book.setBookName("식물의 역사와 신화");
			book.setWriter("브로스");
			book.setAccession("2019년 10월 24일");
			book.setBookInfo("신화와 종교 속에 나타난 식물의 다양한 의미에 대해 생생하게 설명하는 책이다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E007");
			book.setAreaNumber("E");
			book.setBookName("한국 고라니");
			book.setWriter("김백준");
			book.setAccession("2019년 7월 14일");
			book.setBookInfo("고라니의 모든 것을 다룬 생태 전문서다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E008");
			book.setAreaNumber("E");
			book.setBookName("늑대가 온다");
			book.setWriter("최현명");
			book.setAccession("2019년 1월 24일");
			book.setBookInfo("한국 저자가 쓴 늑대에 대한 최초의 기록");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E009");
			book.setAreaNumber("E");
			book.setBookName("코끼리");
			book.setWriter("데스몬드");
			book.setAccession("2019년 9월 10일");
			book.setBookInfo("코끼리에게 마음이 기울어지는 시간 코끼리는 5천5백만 년 전 북아프리카에서 처음 등장한 동물이다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E010");
			book.setAreaNumber("E");
			book.setBookName("고래책");
			book.setWriter("안드레아");
			book.setAccession("2019년 9월 11일");
			book.setBookInfo("인간과 고래는 역사적으로 어떤 관계였는지 각각의 고래들은 어떤 특징이 있는지 단순하면서도 재치 있게 설명한다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E011");
			book.setAreaNumber("E");
			book.setBookName("북극곰");
			book.setWriter("데스몬드");
			book.setAccession("2019년 5월 12일");
			book.setBookInfo("제니 데스몬드의 감성을 담은 논픽션 과학 그림책 흰긴수염고래에 이은 멸종위기 동물의 삶을 다룬 두 번째");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E012");
			book.setAreaNumber("E");
			book.setBookName("세실의 전설");
			book.setWriter("브렌트");
			book.setAccession("2019년 7월 2일");
			book.setBookInfo("2015년 7월 2일한 사자의 죽음이 세상을 바꾸었다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E013");
			book.setAreaNumber("E");
			book.setBookName("늑대의 지혜");
			book.setWriter("엘리");
			book.setAccession("2019년 10월 27일");
			book.setBookInfo("독일 아마존 슈피겔 베스트셀러전 세계 15개국 판권 수출 화제작 길을 잃었을 때 나침반이 되어주는 늑대의 지혜를 만나다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E014");
			book.setAreaNumber("E");
			book.setBookName("도둑고양이 연구");
			book.setWriter("이자와");
			book.setAccession("2019년 8월 9일");
			book.setBookInfo("고양이 전문가에게 배우는 생생한 자연 관찰법");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E015");
			book.setAreaNumber("E");
			book.setBookName("아기 해달 뿌삐");
			book.setWriter("빅토리아");
			book.setAccession("2019년 10월 2일");
			book.setBookInfo("세계 여러 바다에서 평화롭게 살던 해달은 그 수가 순식간에 줄어들어 버렸어요 지금은 겨우 십만 마리 정도만 살아남았습니다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E016");
			book.setAreaNumber("E");
			book.setBookName("걷는 고래    ");
			book.setWriter("테비슨");
			book.setAccession("2019년 10월 9일");
			book.setBookInfo("이 책은 우리가 고래의 기원을 이해하는 데에서 특히 최근 20년 동안에 이룬 놀라운 진전들을 거의 완벽하게 담아냈다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E017");
			book.setAreaNumber("E");
			book.setBookName("보노보");
			book.setWriter("프란스");
			book.setAccession("2019년 6월 15일");
			book.setBookInfo("보노보라는 유인원을 사진과 함께 소개하고 관찰하고 있다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E018");
			book.setAreaNumber("E");
			book.setBookName("고래의 노래");
			book.setWriter("남종영");
			book.setAccession("2019년 10월 8일");
			book.setBookInfo("고래의 노래 우리 곁에 온 고래 그 찰나의 순간들을 기록하다");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E019");
			book.setAreaNumber("E");
			book.setBookName("울지 않는 늑대");
			book.setWriter("팔리");
			book.setAccession("2019년 10월 2일");
			book.setBookInfo("팔리 모왓이 북극 늑대와 1년여를 함께 지낸 생활을 바탕으로 쓴 이 책은 전 세계적으로 멸종 위기에 처한 야생 늑대의 삶에 대한 흥미로운 보고서이다.");
			book.setInventory(1);
			tb_book.add(book);
			
			book = new BookVO();
			book.setBookNumber("E020");
			book.setAreaNumber("E");
			book.setBookName("고래");
			book.setWriter("베르타");
			book.setAccession("2019년 10월 23일");
			book.setBookInfo("이 책은 이 놀라운 생물에 대한 가장 흥미로운 부분을 모아서 펴낸 최초의 저서");
			book.setInventory(1);
			tb_book.add(book);

		}
	
	//리뷰 목록
	public ArrayList<ReviewVO> tb_review = new ArrayList<ReviewVO>();
	{
		ReviewVO review = new ReviewVO();
		review.setReviewNumber(1);
		review.setUserID("solbi");
		review.setBookNumber("A001");
		review.setReviewContent("꼭읽으세요 여러분~~!");
		review.setStarScore("★★★★☆");
		tb_review.add(review);

		review = new ReviewVO();
		review.setReviewNumber(2);
		review.setUserID("hihije");
		review.setBookNumber("A001");
		review.setReviewContent("읽다잤음. 핵노잼");
		review.setStarScore("★☆☆☆☆");
		tb_review.add(review);
	}
	
	
	//예약 목록
	public ArrayList<BookingVO> tb_booking = new ArrayList<BookingVO>();

	//대여
	public ArrayList<RentalVO> tb_rental = new ArrayList<RentalVO>();
	{
		RentalVO rental = new RentalVO();
		rental.setUserID("solbi");
		rental.setBookNumber("A002");
		rental.setRentalDate("2019년 10월 24일");
		rental.setReturnDueDate("2019년 10월 29일");
		//rental.setReturnDate(null);
		tb_rental.add(rental);
		
		rental = new RentalVO();
		rental.setUserID("hihije");
		rental.setBookNumber("A002");
		rental.setRentalDate("2019년 10월 25일");
		rental.setReturnDueDate("2019년 10월 30일");
		//rental.setReturnDate(null);
		tb_rental.add(rental);
		
		rental = new RentalVO();
		rental.setUserID("hihije");
		rental.setBookNumber("A002");
		rental.setRentalDate("2019년 10월 20일");
		rental.setReturnDueDate("2019년 10월 25일");
		//rental.setReturnDate(null);
		tb_rental.add(rental);
	}
	
	//반납
	public ArrayList<RentalVO> tb_return = new ArrayList<RentalVO>();
	
	//쪽지
	public ArrayList<PostVO> tb_post = new ArrayList<PostVO>();
	{
		PostVO post = new PostVO();
		post.setPostNumber(1);
		post.setSenderID("admin");
		post.setAddresseeID("1");
		post.setSendDate("2019년 10월 25일");
		post.setPostTitle("도서관 운영시간 변경 알림");
		post.setPostContents("도서관 운영시간이 변경됩니다.어쩌구저쩌구");
		post.setAsmCheck(true);
		tb_post.add(post);
		
		post = new PostVO();
		post.setPostNumber(1);
		post.setSenderID("admin");
		post.setAddresseeID("1");
		post.setSendDate("2019년 10월 25일");
		post.setPostTitle("대여도서 미납 알림");
		post.setPostContents("*월*일에 대출한 ***의 반납기간이 *일 지났습니다.\n 대여도서의 잦은 미납시 도서관 이용이 제한될 수 있습니다.");
		post.setAsmCheck(false);
		tb_post.add(post);
	}
	
	//공지사항
	public ArrayList<NoticeVO> tb_notice = new ArrayList<NoticeVO>();
	{
		NoticeVO notice = new NoticeVO();
		notice.setNoticeNumber("1");
		notice.setUserID("1");
		notice.setTitle("제목이 들어갑니다.");
		notice.setContents("내용이 들어갑니다.");
		notice.setWriteDate("2019-10-25");
	}
	
	//희망도서 신청
	public ArrayList<RequestVO> tb_request = new ArrayList<RequestVO>();
	
	

	
	
}
















