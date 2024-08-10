create table todev_person (
  id UUID default gen_random_uuid() primary key,
  full_name text null,
  email text null,
  phone text null,
  job text null
);

create table todev_user (
  id UUID default gen_random_uuid() primary key,
  login text not null,
  password text not null,
  person_id UUID,
  foreign key (person_id) references todev_person(id) on delete cascade
);

create table todev_epic (
  id UUID default gen_random_uuid() primary key,
  title text null,
  description text null,
  status boolean not null,
  created_at timestamp null,
  user_id UUID,
  foreign key (user_id) references todev_user(id) on delete cascade
);

create table todev_task (
  id UUID default gen_random_uuid() primary key,
  title text null,
  description text null,
  image_url text null,
  done boolean not null,
  created_at timestamp null,
  epic_id UUID,
  foreign key (epic_id) references todev_epic(id) on delete cascade
);
