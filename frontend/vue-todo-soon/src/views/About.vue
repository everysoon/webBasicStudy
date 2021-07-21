<template>
  <div class="about">
    <h1>Grid Layout 이해하기</h1>
  </div>
  <p>v-container > v-layout > v-flex> v-card</p>
  <v-container style="border: 1px solid red">
    <h3>
      v-container는 Grid 시스템에서 가장 큰 개체 : 안에 layout 및 flex를 포함
    </h3>
    <ul>
      <li>fluid : 화면에 따라 사이즈 바뀌는게 아니라 항상 최대 넓이</li>
      <li>justify-center : 컨텐츠 가운데 정렬</li>
      <li>
        grid-list-(size) : 각 v-flex아이템들이 세로 및 가로로 몇 픽셀 떨어질지
        <ul>
          <li>xs = 2px</li>
          <li>sm = 4px</li>
          <li>md = 8px</li>
          <li>lg = 16px</li>
          <li>xl = 24px</li>
        </ul>
      </li>
      <li>
        fill-height : 칼럼엘리먼트의 높이가 부모랑 자식요소로 채워지도록 만듬
      </li>
    </ul>
    <v-layout style="border:1px solid blue">
      <h3>섹션을 구분하는데 사용, v-flex를 포함한다.</h3>
      <ul>
        <li>
          wrap : 엘리먼트가 100%넘어가면 컨테이너 안에 자식노드를
          감싸도록!(다음줄로 넘김)
        </li>
        <li>row : 좌에서 우로</li>
        <li>column : 위에서 아래로</li>
        <li>reverse: 표시방향을 반대로 뒤집음</li>
        <li>align-content-() : v-layout을 y축 방향으로 정렬</li>
        <li>
          justify-() : v-layout을 X축 방향으로 정렬
          <ul>
            <li>justify-center : X축 가운데 설정</li>
            <li>
              justify-space-between : x축을 기준으로 컨텐츠 사이에 빈공간두고
              생성
            </li>
          </ul>
        </li>
      </ul>
      <v-flex style="border:1px solid green">
        <h3>
          Flex박스는 행 또는 열로 정렬, 가로축(Main-axis) 세로축(Cross-axis)
        </h3>
        <h3>
          Css에 flex: 1 1 auto 와 같이 정의 (첫번째 숫자 : flex-grow, 두번째숫자
          :flex-shrink ,세번째 : flex-basis의 사이즈)
        </h3>
        <v-card>
          <v-card-title>CSS의 Flex</v-card-title>
          <ul>
            <li>
              flex-basis : 항목의 크기(디폴트는 auto) 각 내용물의 크기만큼 공간
              차지
            </li>
            <li>
              flex-grow : 주축에서 남는공간을 flex컨테이너안에 항목들에게 분배 /
              vuetify에선 1로 고정 <br />
              양수로 하면 flex-basis값 이상으로 늘어날 수 있음
            </li>
            <li>
              flex-shrink : 주축의 공간이 부족하면 어떻게 사이즈를 줄일건지 ,
              양수이면 flex-basis지정된 사이즈보다 작아짐
            </li>
          </ul>
        </v-card>
        <ul>
          <li>
            align-self-() : Y축 방향으로 정렬/ align-self-end는 v-flex를
            v-layout맨 아래에 생성
          </li>
          <li>
            size(1-12)<br />
            ex) xs12 : xs크기 이상에서 12로 고정 <br />
            lg12 :lg크기이상에서 12로 고정 <br />
            xs사이즈 이상에서 12, md사이즈 이상에선 6
          </li>
          <li>
            offest-size(0-12) : 장치 크기별로 v-flex가 그리드 몇 칸 뒤에
            생겨야하는지 지정 <br />
            ex) offest-xs6 : xs보다 큰 장치에서 6칸의 빈공간을 두고 생성
          </li>
          <li>
            order-size(0-12) : 그리드 항목의 순서 지정 가능 / 장치 크기별 지정
            가능 <br />
            ex) order-lg2 : lg보다 큰 장치에서 2번째로 보여지도록 지정
          </li>
          v-spacer : 컴포넌트 사이 빈 공간을 생성하고 싶을때!
        </ul>
      </v-flex>
      <v-flex style="border:1px solid yellow"></v-flex>
    </v-layout>
    <v-layout style="border:1px solid pink">
      <v-flex style="border:1px solid purple">asdads</v-flex>
    </v-layout>
  </v-container>
</template>
<script>
export default {};
</script>
<style></style>
