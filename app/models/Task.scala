package models

import java.time.ZonedDateTime

// jsr310._をつけないとダメ
import scalikejdbc._, jsr310._
import skinny.orm._

case class Task(id: Option[Long], content: String,status: Option[String], createAt: ZonedDateTime, updateAt: ZonedDateTime)

object Task extends SkinnyCRUDMapper[Task] {

  override def tableName = "tasks"

  override def defaultAlias: Alias[Task] = createAlias("t")

  // Taskインスタンスに変更
  override def extract(rs: WrappedResultSet, n: ResultName[Task]): Task =
    autoConstruct(rs, n)

  // Taskインスタンスをカラムと紐づけるヘルパー
  private def toNamedValues(record: Task): Seq[(Symbol,Any)] = Seq(
    'content -> record.content,
    'status -> record.status,
    'createAt -> record.createAt,
    'updateAt -> record.updateAt
  )

  def create(task: Task)(implicit session: DBSession): Long =
    createWithAttributes(toNamedValues(task): _*)

  def update(task: Task)(implicit session: DBSession): Int =
    updateById(task.id.get).withAttributes(toNamedValues(task): _*)


}