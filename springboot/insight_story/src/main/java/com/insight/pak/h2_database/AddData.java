package com.insight.pak.h2_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

/* 
    database에 데이터 입력하는 부분
    경로만 적으면 db에 데이터 저장
*/

@Controller
public class AddData {
	@Autowired
    private StoryRepository storyRepository;

    String prompt = 
    "#입력문:\n" +
    "입력문: 인물1: 진산월(이름), ENTP(MBTI), 산적에 의해 부모와 집, 돈을 잃고 떠돌아 다니던 중, 무당파에 들어가기 위해 무당파 본산 대문 앞에서 이틀 째 기다리고 있음, 배경: 무림, 장르: 무협";
    String name = "천하를 꿈꾸는 자";
    String char1 ="진산월";
    String summary = 
    "무림의 세계에서 부모와 집, 모든 재산을 산적에게 잃고 떠돌아다니던 진산월. 그는 무당파에 들어가기 위해 무당파 본산 대문 앞에서 이틀째 기다리고 있다. 재치 있고 호기심 많은 성격의 산월은 잃어버린 모든 것을 되찾기 위해 새로운 길을 찾고자 한다.\r\n" + //
                "어느 날, 무당파의 문이 열리고 산월은 그의 운명을 바꿀 기회를 맞이하게 된다. 무림의 세계에 발을 들인 그는 다양한 인물들과 만나고, 새로운 기술을 익히며, 잃어버린 가족의 복수를 위해 힘을 키워나간다.\r\n" + //
                "하지만 무당파에서도 그의 도전은 끝나지 않는다. 산월은 무림의 어두운 비밀을 밝혀내고, 자신만의 방식으로 정의를 구현하려 한다. 그 과정에서 그는 친구와 적을 구분하며, 무림의 질서를 바로잡기 위해 고군분투한다.\r\n" + //
                "재치와 용기로 무림을 헤쳐나가는 진산월의 이야기. \"천하를 꿈꾸는 자\"는 무협의 세계에서 펼쳐지는 그의 모험과 성장, 그리고 정의를 위한 끝없는 도전을 그린다.";
    String image = "/img/a_dreamer_of_unification.png";
    String image_char = "/img/a_dreamer_of_unification_char.png";
    String prompt2 = 
    "#입력문:\n" +
    "입력문: 인물1: 브라이트 아실리(이름), ENFJ(MBTI), 전대 왕비의 딸로 왕녀로 살았으나 현대 왕비가 전대 왕비에게 죄를 뒤집어 씌워 자신의 어머니인 전대 왕비는 죽임을 당하고 자신은 쫓겨나 거지촌에서 살고 있다. 실리아 본인은 쫓겨난 이유도 모른 채 거지촌에서 살다가 우연히 자신의 의붓 동생 블론디와 전대 용사 안토니와 만나게 되었다, 인물2: 다리아 블론디(이름), ISFP(MBTI), 현대 왕비의 딸로 현대 왕녀이다. 현대 왕비가 전대 왕비에게 죄를 뒤집어 씌웠다는 것을 알고 있으며 이 때문에 의붓언니인 아실리를 거지촌에서 우연히 마주쳤음에도 불구하고 모른척한다, 인물3: 패트릭 안토니(이름), ESTP(MBTI), 용을 쓰러트린 전대 용사로, 아실리를 사랑했으나 폐위된 이유로 못 만나고 있었다. 안토니는 아실리가 거지촌에 살게 된 이유를 알고 있으며 블론디 옆에서 현대 왕비에게 복수할 때를 기다리고 있다, 배경: 중세시대, 장르: 판타지";
    String name2 = "왕녀의 복수";
    String char2 ="브라이트 아실리, 다리아 블론디, 패트릭 안토니";
    String summary2 = 
    "중세 시대의 어느 왕국, 전대 왕비의 딸로 왕녀였던 브라이트 아실리는 어머니가 누명을 쓰고 처형당한 후, 거지촌에서 비참한 삶을 살게 된다. 자신이 쫓겨난 이유도 모른 채 살아가던 아실리는 우연히 의붓동생 다리아 블론디와 전대 용사 패트릭 안토니를 만나게 된다.\r\n" + //
                "현대 왕녀인 블론디는 어머니인 현대 왕비가 전대 왕비에게 죄를 뒤집어씌운 사실을 알고 있다. 아실리를 거지촌에서 우연히 마주쳤지만, 모른척하며 진실을 숨긴다.\r\n" + //
                "한편, 용을 쓰러트린 전대 용사 안토니는 아실리를 사랑했으나, 그녀가 쫓겨난 이유로 함께할 수 없었다. 그는 현대 왕비에게 복수할 날을 기다리며 블론디의 곁에서 기회를 엿본다.\r\n" + //
                "브라이트 아실리는 자신의 비참한 운명을 극복하고 진실을 밝혀내기 위해, 안토니와 함께 현대 왕비에게 맞서 싸우기로 결심한다. 이들은 복수를 통해 정의를 되찾고, 왕국의 진정한 평화를 이루기 위해 힘을 합치는데...";
    String image2 = "/img/the_revenge_of_royal_woman.png";
    String image2_char = "/img/the_revenge_of_royal_woman_char.png";
    String prompt3 = 
    "#입력문:\n" +
    "입력문: 인물1: 셜록 홈즈(이름), INTJ(MBTI), 명석한 두뇌와 뛰어난 관찰력으로 유명한 탐정이다. 런던 베이커가 221B에서 살고 있으며, 각종 사건을 해결하며 명성을 쌓아가고 있다. 종종 존 왓슨과 함께 사건을 해결하며 왓슨과의 우정도 깊다. 인물2: 존 왓슨(이름), ISFJ(MBTI), 셜록 홈즈의 절친한 친구이자 동료이며, 베테랑 군의관 출신이다. 홈즈의 사건 해결을 도우며 그 과정을 기록하고 있다. 의학 지식을 활용해 홈즈의 탐정 업무에 큰 도움을 준다. 배경: 19세기 런던, 장르: 추리";
    String name3 = "베이커가의 비밀";
    String char3 = "셜록 홈즈, 존 왓슨";
    String summary3=
    "19세기 런던, 명석한 두뇌와 뛰어난 관찰력으로 유명한 탐정 셜록 홈즈는 베이커가 221B에 거주하며 각종 사건을 해결해 명성을 쌓아가고 있다. 그의 절친한 친구이자 동료인 존 왓슨은 베테랑 군의관 출신으로, 홈즈의 사건 해결을 돕고 그 과정을 기록한다. 의학 지식을 활용해 홈즈의 탐정 업무에 큰 도움을 주는 왓슨은 그의 신뢰받는 파트너이다.\r\n" + //
                "런던을 배경으로 펼쳐지는 미스터리한 사건들 속에서, 홈즈와 왓슨은 서로의 지식을 결합해 수많은 난제를 해결해 나간다. 살인, 실종, 도난 등 다양한 사건들이 두 사람 앞에 펼쳐지며, 그들의 우정과 협력은 더욱 깊어진다.\r\n" + //
                "셜록 홈즈는 뛰어난 추리력으로 사건의 본질을 꿰뚫어보고, 왓슨은 그의 곁에서 충실히 지원한다. 그들은 함께 런던의 어두운 골목과 고풍스러운 저택을 탐험하며 진실을 찾아 나선다. \"베이커가의 비밀\"은 두 명의 뛰어난 탐정이 런던을 무대로 벌이는 스릴 넘치는 추리와 우정의 이야기를 그린다.";
    String image3 = "/img/the_secret_of_baker.png";
    String image3_char = "/img/the_secret_of_baker_char.png";
    String prompt4 = 
    "#입력문:\n" +
    "입력문: 인물1: 제인 도(이름), INFJ(MBTI), 부모가 살해당한 후 할머니와 함께 살며, 귀신을 보거나 소통할 수 있는 특별한 능력을 가진 소녀다. 제인의 할머니는 유명한 퇴마사 마이클 스미스에게 도움을 요청해, 마이클이 제인의 스승이 되어 퇴마 기술을 가르치기 시작한다. 인물2: 마이클(이름), ESTJ(MBTI), 가족을 잃은 후부터 귀신과 싸워온 퇴마사다. 인물3: 에밀리 존슨(이름), ENFP(MBTI), 제인의 가장 친한 친구로, 심령현상에 깊은 관심을 가지며 제인을 지지하고 함께 초자연적인 현상을 조사한다. 이들은 작은 마을에서 기이한 사건들을 해결해 나가며, 어둠의 세력과 맞서 싸운다. 배경: 1970년대 미국, 장르: 공포, 스릴러";
    String name4 = "어둠 속의 속삭임";
    String char4 = "제인 도, 마이클, 에밀리 존슨";
    String summary4 = 
    "1970년대 미국의 작은 마을, 제인 도는 부모가 살해당한 후 특별한 능력으로 귀신과 소통하며 할머니와 함께 살아간다. 제인은 할머니의 요청으로 유명한 퇴마사 마이클 스미스에게 퇴마 기술을 배우기 시작한다.\r\n" + //
                "한편, 가족을 잃은 후 귀신과 싸워온 마이클은 제인의 스승이 되어 그녀에게 자신의 지식을 전수한다. 제인의 가장 친한 친구인 에밀리 존슨은 심령현상에 깊은 관심을 가지며, 제인을 지지하고 함께 초자연적인 현상을 조사한다.\r\n" + //
                "이들 세 사람은 마을에서 일어나는 기이한 사건들을 해결해 나가며, 어둠의 세력과 맞서 싸운다. 수많은 도전과 위험 속에서, 이들은 서로의 유대감을 강화하며 마을을 지키기 위해 고군분투한다.\r\n" + //
                "귀신과의 싸움, 어둠의 힘에 맞서는 퇴마사들의 이야기. 1970년대 미국의 어두운 마을에서 펼쳐지는 공포와 스릴러가 가득한 이야기, \"어둠 속의 속삭임\"이 지금 시작된다.";
    String image4 = "/img/a_whisper_in_the_dark.png";
    String image4_char = "/img/a_whisper_in_the_dark_char.png";
    String prompt5 = 
    "#입력문:\n" +
    "입력문: 인물1: 서윤지(Seo Yoonji), ISFJ(MBTI), 대학교 3학년으로 성실하고 조용한 성격을 가지고 있다. 유학 후 돌아와 다시 학교 생활을 시작하면서 주변 사람들과의 복잡한 관계에 얽히게 된다. 인물2: 강준호(Kang Junho), INTJ(MBTI), 대학생으로 차가운 성격과 뛰어난 두뇌를 가지고 있다. 겉보기에는 완벽해 보이지만 어두운 면모를 숨기고 있다. 윤지와 가까워지며 그녀에게 특별한 관심을 보인다. 인물3: 이태민(Lee Taemin), ESFP(MBTI), 윤지의 고등학교 동창으로 활발하고 사교적인 성격을 가졌다. 오랜만에 윤지를 만나게 되면서 그녀를 돕고 보호하려 한다. 배경: 현대 대학교, 장르: 로맨스, 드라마";
    String name5="다시 만난 우리";
    String char5 = "서윤지, 강준호, 이태민";
    String summary5 = 
    "현대 대학교를 배경으로, 성실하고 조용한 성격의 서윤지는 유학 후 돌아와 다시 학교 생활을 시작한다. 대학 3학년인 윤지는 예전과 달라진 주변 사람들과의 복잡한 관계에 얽히게 된다.\r\n" + //
                "강준호는 차가운 성격과 뛰어난 두뇌를 가진 대학생으로, 겉보기에는 완벽해 보이지만 어두운 면모를 숨기고 있다. 윤지와 가까워지며 그녀에게 특별한 관심을 보이는 준호는 자신만의 비밀을 간직한 채 그녀의 삶에 깊숙이 들어오게 된다.\r\n" + //
                "윤지의 고등학교 동창인 이태민은 활발하고 사교적인 성격을 가지고 있다. 오랜만에 윤지를 만나게 된 태민은 그녀를 돕고 보호하려 하며, 윤지와의 우정을 다시 한 번 확인하게 된다.\r\n" + //
                "복잡하게 얽힌 인연 속에서, 이들은 각자의 상처와 비밀을 마주하며 사랑과 우정을 키워나간다. 현대 대학교에서 펼쳐지는 로맨스와 드라마가 가득한 이야기, \"다시 만난 우리\"가 지금 시작된다.\r\n";
    String image5 = "/img/again_we_meet.png";
    String image5_char = "/img/again_we_meet_char.png";
    String prompt6 = 
    "#입력문:\n" +
    "입력문: 인물1: 데이비드 크레인(이름), INTJ(MBTI), 뛰어난 기술력을 가진 기업가로, 사람들의 꿈에 들어가 정보를 훔치는 능력을 가지고 있다. 하지만 아내를 잃은 후 죄책감에 시달리며, 자신의 능력을 더 이상 사용하지 않기로 결심한다. 인물2: 엘리자베스 로렌스(이름), ENFP(MBTI), 심리학자로, 사람들의 꿈을 분석하는 능력을 가지고 있다. 데이비드에게 새로운 임무를 제안하며 그의 능력을 다시 사용하게 하려 한다. 인물3: 마크 스티븐스(이름), ESTP(MBTI), 전직 군인으로, 데이비드의 팀에 합류해 꿈속 임무를 수행한다. 그는 빠른 판단력과 행동력으로 팀의 중요한 일원이다. 배경: 근미래 도시, 장르: SF";
    String name6 = "꿈의 경계";
    String char6 = "데이비드 크레인, 엘리자베스 로렌스, 마크 스티븐스";
    String summary6=
    "근미래의 도시, 사람들의 꿈은 더 이상 단순한 무의식의 영역이 아니다. 뛰어난 기술력을 가진 기업가 데이비드 크레인(INTJ)은 사람들의 꿈에 들어가 정보를 훔칠 수 있는 능력을 가지고 있다. 하지만 아내를 잃은 후 죄책감에 시달리며, 그는 자신의 능력을 더 이상 사용하지 않기로 결심한다.\r\n" + //
                "한편, 심리학자 엘리자베스 로렌스(ENFP)는 사람들의 꿈을 분석하는 특별한 능력을 지녔다. 그녀는 데이비드에게 새로운 임무를 제안하며 그의 능력을 다시 사용하게 하려 한다. 그 임무는 바로, 꿈속에 숨어 있는 위험을 제거하고 사람들의 무의식을 지키는 것이다.\r\n" + //
                "전직 군인 마크 스티븐스(ESTP)는 데이비드의 팀에 합류해 꿈속 임무를 수행한다. 그의 빠른 판단력과 행동력은 팀의 중요한 자산이다.\r\n" + //
                "이제, 데이비드, 엘리자베스, 마크는 꿈의 경계를 넘나들며 사람들의 무의식을 지켜내야 한다. 꿈과 현실의 경계가 흐려지는 세계에서, 그들은 어떠한 선택을 하게 될 것인가? 한편, 꿈속에서 마주하는 위험은 그들 각자의 트라우마와 맞물려 예기치 못한 방향으로 흘러가는데...\r\n" + //
                "꿈의 세계를 무대로 펼쳐지는 새로운 SF 미스터리! 현실과 꿈의 경계에서 벌어지는 치열한 싸움이 지금 시작된다!";
    String image6 = "/img/boundary_of_a_dream.png";
    String image6_char = "/img/boundary_of_a_dream_char.png";

    @GetMapping("/add/story")
    public void add_story() {
        Story story = new Story();
        story.setId(0);
        story.setImage(image);
        story.setSummary(summary);
        story.setPrompt(prompt);
        story.setName(name);
        story.setImage_char(image_char);
        story.setCharacter(char1);
        
        this.storyRepository.save(story);

        Story story2 = new Story();
        story2.setId(0);
        story2.setImage(image2);
        story2.setSummary(summary2);
        story2.setPrompt(prompt2);
        story2.setName(name2);
        story2.setImage_char(image2_char);
        story2.setCharacter(char2);
        
        this.storyRepository.save(story2);

        Story story3 = new Story();
        story3.setId(0);
        story3.setImage(image3);
        story3.setSummary(summary3);
        story3.setPrompt(prompt3);
        story3.setName(name3);
        story3.setImage_char(image3_char);
        story3.setCharacter(char3);
        
        this.storyRepository.save(story3);

        Story story4 = new Story();
        story4.setId(0);
        story4.setImage(image4);
        story4.setSummary(summary4);
        story4.setPrompt(prompt4);
        story4.setName(name4);
        story4.setImage_char(image4_char);
        story4.setCharacter(char4);

        this.storyRepository.save(story4);

        Story story5 = new Story();
        story5.setId(0);
        story5.setImage(image5);
        story5.setSummary(summary5);
        story5.setPrompt(prompt5);
        story5.setName(name5);
        story5.setImage_char(image5_char);
        story5.setCharacter(char5);

        this.storyRepository.save(story5);

        Story story6 = new Story();
        story6.setId(0);
        story6.setImage(image6);
        story6.setSummary(summary6);
        story6.setPrompt(prompt6);
        story6.setName(name6);
        story6.setImage_char(image6_char);
        story6.setCharacter(char6);

        this.storyRepository.save(story6);
    }
}