package me.siyoon.practiceunittestingandjunit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
//모키톡 관련 빈들만 등록해서 빠르고 강력한 유닛테스트 가능
public class MyServiceTest {
    @InjectMocks//Mock 들을 주입받는다.
    MyService myService;
    @Mock //Mock 으로 선언
    MyRepository myRepository;

    @Test
    public void MyRepoTest() throws Exception {
        //given
        Mockito
                .when(myRepository.myRepoMethod())
                .thenReturn("Fake Repo Method");

        //when
        final String s = myRepository.myRepoMethod();

        //then
        assertEquals(s,"Fake Repo Method");
    }

    @Test
    public void MyEntityTest() throws Exception {
        //given
        final MyEntity mock = Mockito.mock(MyEntity.class);
        Mockito
                .when(mock.myEntityMethod())
                .thenReturn("Fake Entity Method");

        //when
        final String s = mock.myEntityMethod();

        //then
        assertEquals(s, "Fake Entity Method");
    }
}