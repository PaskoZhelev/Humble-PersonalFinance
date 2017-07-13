<?php

$type = $_GET['type'];

// Chart bar data
if($type=='bar'){
  include "chart-data-bar.php";
  echo json_encode($data);
}

if($type=='barstacked'){
  include "chart-data-barstacked.php";
  echo json_encode($data);
}

if($type=='area'){
  include "chart-data-area.php";
  echo json_encode($data);
}

if($type=='line'){
  include "chart-data-line.php";
  echo json_encode($data);
}

if($type=='pie'){
  include "chart-data-pie.php";
  echo json_encode($data);
}


?>